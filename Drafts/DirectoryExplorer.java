package Drafts;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * A simple utility for exploring the contents of a directory, including files and subdirectories.
 */
public class DirectoryExplorer {

    /**
     * Represents a node in the directory tree, containing information about a file or directory.
     */
    static class TreeNode {
        /** The name of the file or directory. */
        public String name;

        /** The type of the node (0 for file, 1 for directory). */
        public int type;

        /** The size of the file in bytes (0 for directories). */
        public long size;

        /** The last modified date of the file or directory. */
        public long date;

        /**
         * Constructs a new Node with the specified parameters.
         *
         * @param name The name of the file or directory.
         * @param type The type of the node (0 for file, 1 for directory).
         * @param size The size of the file in bytes (0 for directories).
         * @param date The last modified date of the file or directory.
         */
        public TreeNode(String name, int type, long size, long date) {
            this.name = name;
            this.type = type;
            this.size = size;
            this.date = date;
        }

        /**
         * Returns a formatted string representation of the Node.
         *
         * @return The formatted string representation.
         */
        @Override
        public String toString() {
            Date dateInFormat = new Date(date);
            if (type == 0) {
                return String.format("%8d bytes\t%s\t%s", size, dateInFormat, name);
            } else {
                return String.format("\t<DIR>\t%s\t\t%s", dateInFormat, name);
            }
        }
    }

    /**
     * Retrieves the contents of a directory and returns a list of Nodes representing files and subdirectories.
     *
     * @param directoryPath The path of the directory to explore.
     * @return An ArrayList of Nodes representing the contents of the directory.
     * @throws IOException If an I/O error occurs while exploring the directory.
     */
    public static ArrayList<TreeNode> getDirectoryContents(String directoryPath) throws IOException {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        File directory = new File(directoryPath);

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                nodes.add(new TreeNode(file.getName(), 1, 0, file.lastModified()));
            } else {
                nodes.add(new TreeNode(file.getName(), 0, file.length(), file.lastModified()));
            }
        }
        return nodes;
    }

    /**
     * Displays the contents of a directory, including information about each file and subdirectory.
     *
     * @param nodes The ArrayList of Nodes representing the contents of the directory.
     */
    public static void displayDirectoryContents(ArrayList<TreeNode> nodes) {
        long totalSize = 0;
        for (TreeNode node : nodes) {
            System.out.println(node);
            totalSize += node.size;
        }
        System.out.println("Total size: " + totalSize + " bytes");
    }

    /**
     * The main method to execute the directory exploration and display.
     *
     * @param args The command-line arguments (not used in this implementation).
     * @throws IOException If an I/O error occurs during the directory exploration.
     */
    public static void main(String[] args) throws IOException {
        String directoryPath = "E:\\study\\Btech IT\\2nd Year\\3rd sem\\FDS\\Lab";
        ArrayList<TreeNode> nodes = getDirectoryContents(directoryPath);
        displayDirectoryContents(nodes);
    }
}