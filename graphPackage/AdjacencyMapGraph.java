package graphPackage;

import hashMapPackage.Map;
import hashMapPackage.ProbeHashMap;
import positionalListPackage.Position;
import positionalListPackage.PositionalLinkedList;

@SuppressWarnings("unchecked")
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;
        Map<Vertex<V>, Edge<E>> outgoing, incoming;
        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new ProbeHashMap<>();
            if(graphIsDirected) {
                incoming = new ProbeHashMap<>();
            }
            else {
                incoming = outgoing;
            }
        }
        public V getElement() {
            return element;
        }
        public void setPosition(Position<Vertex<V>> p) {
            pos = p;
        }
        public Position<Vertex<V>> getPosition() {
            return pos;
        }
        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }
        public Map<Vertex<V>, Edge<E>> getIncomimg() {
            return incoming;
        }
    }
    class InnerEdge<E> implements Edge<E> {
        E element;
        Position<Edge<E>> pos;
        Vertex<V>[] endpoints;
        public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};
        }
        public E getElement() {
            return element;
        }
        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }
        public void setPosition(Position<Edge<E>> p) {
            pos = p;
        }
        public Position<Edge<E>> getPosition() {
            return pos;
        }
    }
    boolean isDirected;
    PositionalLinkedList<Vertex<V>> vertices = new PositionalLinkedList<>();
    PositionalLinkedList<Edge<E>> edges = new PositionalLinkedList<>();
    public AdjacencyMapGraph(boolean directed) {
        isDirected = directed;
    }
    public int numVertices() {
        return vertices.size();
    }
    public Iterable<Vertex<V>> vertices() {
        return vertices.elements();
    }
    public int numEdges() {
        return edges.size();
    }
    public Iterable<Edge<E>> edges() {
        return edges.elements();
    }
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getOutgoing().size();
    }
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getOutgoing().valueSet();
    }
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getIncomimg().size();
    }
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        return vert.getIncomimg().valueSet();
    }
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> origin = (InnerVertex<V>) u;
        return origin.getOutgoing().get(v);
    }
    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        return edge.getEndpoints();
    }
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        Vertex<V>[] endpoints = edge.getEndpoints();
        if(endpoints[0] == v) {
            return endpoints[1];
        }
        else if(endpoints[1] == v) {
            return endpoints[0];
        }
        else {
            throw new IllegalArgumentException("v is not incident to this edge.");
        }
    }
    public Vertex<V> insertVertex(V e) {
        InnerVertex<V> v = new InnerVertex<>(e, isDirected);
        v.setPosition(vertices.addLast(v));
        return v;
    }
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) {
        if(getEdge(u, v) == null) {
            InnerEdge<E> edge = new InnerEdge<>(u, v, e);
            edge.setPosition(edges.addLast(edge));
            InnerVertex<V> origin = (InnerVertex<V>) u;
            InnerVertex<V> dest = (InnerVertex<V>) v;
            origin.getOutgoing().put(v, edge);
            dest.getIncomimg().put(u, edge);
            return edge;
        }
        else {
            throw new IllegalArgumentException("Edge from u to v exists.");
        }
    }
    public void removeVertex(Vertex<V> v) {
        InnerVertex<V> vert = (InnerVertex<V>) v;
        for(Edge<E> e : vert.getOutgoing().valueSet()) {
            removeEdge(e);
        }
        for(Edge<E> e : vert.getIncomimg().valueSet()) {
            removeEdge(e);
        }
        vertices.remove(vert.getPosition());
    }
    public void removeEdge(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        edges.remove(edge.getPosition());
    }
    public Vertex<V> findVertex(V value) {
        for(Position<Vertex<V>> p : vertices.positions()) {
            if(p.getElement().getElement() == value) {
                return p.getElement();
            }
        }
        return null;
    }
    public Edge<E> findEdge(E edge) {
        for(Position<Edge<E>> p : edges.positions()) {
            if(p.getElement().getElement() == edge) {
                return p.getElement();
            }
        }
        return null;
    }
}
