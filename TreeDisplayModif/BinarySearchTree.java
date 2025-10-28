import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class BinarySearchTree {
    Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.getKey()) {
            root.setLeft(insertRec(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(insertRec(root.getRight(), key));
        }
        return root;
    }

    private int maxDepth(Node node) {
        if (node == null) return 0;
        // GANTI: pakai getLeft() dan getRight()
        return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
    }

    public void displayTriangularTree() {
        if (root == null) {
            System.out.println("Pohon kosong.");
            return;
        }

        int max_depth = maxDepth(root);
        int[] xCounter = {0};
        assignPositions(root, 0, xCounter);

        List<List<Node>> nodesByLevel = new ArrayList<>();
        for (int i = 0; i < max_depth; i++) {
            nodesByLevel.add(new ArrayList<>());
        }
        fillNodesByLevel(root, nodesByLevel);

        printTreeLevels(nodesByLevel, max_depth);
    }

    private void assignPositions(Node node, int depth, int[] xCounter) {
        if (node == null) {
            return;
        }
        // GANTI: pakai getLeft() dan getRight()
        assignPositions(node.getLeft(), depth + 1, xCounter);

        // GANTI: pakai setdeep_x() dan setdeep_y()
        node.setdeep_x(xCounter[0]++);
        node.setdeep_y(depth);

        // GANTI: pakai getLeft() dan getRight()
        assignPositions(node.getRight(), depth + 1, xCounter);
    }

    private void fillNodesByLevel(Node root, List<List<Node>> nodesByLevel) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // GANTI: pakai getdeep_y()
            nodesByLevel.get(current.getdeep_y()).add(current);

            // GANTI: pakai getLeft()
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            // GANTI: pakai getRight()
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }
    private void printTreeLevels(List<List<Node>> nodesByLevel, int max_depth) {
        // ... (Bagian 'totalWidth' tidak perlu diganti, biarkan saja) ...
        int totalWidth = 0;
         if (!nodesByLevel.isEmpty()) {
              List<Node> lastLevelNodes = nodesByLevel.get(nodesByLevel.size() - 1);
              if (!lastLevelNodes.isEmpty()) {
                  Node lastNode = lastLevelNodes.get(lastLevelNodes.size() - 1);
                  totalWidth = lastNode.getdeep_x() + 1;
              }
         }
         if (totalWidth == 0 && root != null) totalWidth = 1;


        // === MULAI GANTI DARI SINI ===

        for (int y = 0; y < max_depth; y++) {
            List<Node> currentLevelNodes = nodesByLevel.get(y);
            // GANTI: pakai getdeep_x() untuk sorting
            Collections.sort(currentLevelNodes, (n1, n2) -> Integer.compare(n1.getdeep_x(), n2.getdeep_x()));

            StringBuilder nodeRow = new StringBuilder();
            int currentX = 0;
            
            // --- Bagian 1: Buat dan Cetak Baris ANGKA (nodeRow) ---
            for (Node node : currentLevelNodes) {
                // GANTI: pakai getdeep_x()
                // Tambahkan spasi sebelum node
                for (int i = 0; i < (node.getdeep_x() - currentX) * 3; i++) {
                    nodeRow.append(" ");
                }

                // Cetak node dengan format 3 karakter
                nodeRow.append(String.format("%3d", node.getKey()));
                
                // GANTI: pakai getdeep_x()
                currentX = node.getdeep_x() + 1;
            }
            // Cetak baris angka (tanpa .trim())
            System.out.println(nodeRow.toString());


            // --- Bagian 2: Buat dan Cetak Baris CABANG (branchRow) ---
            if (y < max_depth - 1) {
                // Buat array karakter kosong seukuran lebar total
                char[] branchChars = new char[totalWidth * 3];
                for (int i = 0; i < branchChars.length; i++) {
                    branchChars[i] = ' ';
                }

                // Isi array dengan cabang
                for (Node parent : currentLevelNodes) {
                    
                    // Jika ada anak KIRI
                    // GANTI: pakai getLeft() dan getdeep_x()
                    if (parent.getLeft() != null) {
                        // Posisi karakter tengah anak kiri
                        int child_char_pos = parent.getLeft().getdeep_x() * 3 + 1; 
                        // Taruh '/' satu karakter di KANAN anak (mendekati parent)
                        branchChars[child_char_pos + 1] = '/';
                    }

                    // Jika ada anak KANAN
                    // GANTI: pakai getRight() dan getdeep_x()
                    if (parent.getRight() != null) {
                        // Posisi karakter tengah anak kanan
                        int child_char_pos = parent.getRight().getdeep_x() * 3 + 1;
                        // Taruh '\' satu karakter di KIRI anak (mendekati parent)
                        branchChars[child_char_pos - 1] = '\\';
                    }
                }
                // Cetak baris cabang (tanpa .trim())
                System.out.println(new String(branchChars));
            }
        }
        
        // === SELESAI GANTI ===
    }

}