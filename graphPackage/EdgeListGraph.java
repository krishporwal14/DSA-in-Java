package graphPackage;

import positionalListPackage.Position;
import positionalListPackage.PositionalLinkedList;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class EdgeListGraph<V, E> implements Graph<V, E> {
    class InnerVertex<V> implements Vertex<V> {
        V element;
        Position<Vertex<V>> pos;

        public InnerVertex(V elem) {
            element = elem;
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

    PositionalLinkedList<Vertex<V>> vertices = new PositionalLinkedList<>();
    PositionalLinkedList<Edge<E>> edges = new PositionalLinkedList<>();

    public EdgeListGraph() {
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
        int count = 0;
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(v)) {
                count++;
            }
        }
        return count;
    }

    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        List<Edge<E>> outgoing = new ArrayList<>();
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(v)) {
                outgoing.add(edge);
            }
        }
        return outgoing;
    }

    public int inDegree(Vertex<V> v) {
        int count = 0;
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[1].equals(v)) {
                count++;
            }
        }
        return count;
    }

    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        List<Edge<E>> incoming = new ArrayList<>();
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[1].equals(v)) {
                incoming.add(edge);
            }
        }
        return incoming;
    }

    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        for (Edge<E> edge : edges()) {
            InnerEdge<E> e = (InnerEdge<E>) edge;
            if (e.getEndpoints()[0].equals(u) && e.getEndpoints()[1].equals(v)) {
                return edge;
            }
        }
        return null;
    }

    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        return edge.getEndpoints();
    }

    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerEdge<E> edge = (InnerEdge<E>) e;
        Vertex<V>[] endpoints = edge.getEndpoints();
        if (endpoints[0].equals(v)) {
            return endpoints[1];
        } else if (endpoints[1].equals(v)) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("v is not incident to this edge.");
        }
    }

    public Vertex<V> insertVertex(V e) {
        InnerVertex<V> v = new InnerVertex<>(e);
        v.setPosition(vertices.addLast(v));
        return v;
    }

    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E e) {
        InnerEdge<E> edge = new InnerEdge<>(u, v, e);
        edge.setPosition(edges.addLast(edge));
        return edge;
    }

    public void removeVertex(Vertex<V> v) {
        for (Edge<E> e : incomingEdges(v)) {
            removeEdge(e);
        }
        for (Edge<E> e : outgoingEdges(v)) {
            removeEdge(e);
        }
        vertices.remove(((InnerVertex<V>) v).getPosition());
    }

    public void removeEdge(Edge<E> e) {
        edges.remove(((InnerEdge<E>) e).getPosition());
    }

    public Vertex<V> findVertex(V value) {
        for (Position<Vertex<V>> p : vertices.positions()) {
            if (p.getElement().getElement().equals(value)) {
                return p.getElement();
            }
        }
        return null;
    }

    public Edge<E> findEdge(E edge) {
        for (Position<Edge<E>> p : edges.positions()) {
            if (p.getElement().getElement().equals(edge)) {
                return p.getElement();
            }
        }
        return null;
    }
}
