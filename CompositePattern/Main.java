public class Main {
    public static void main(String[] args) {
        Leaf file1 = new Leaf("File1.txt");
        Leaf file2 = new Leaf("File2.txt");
        Leaf file3 = new Leaf("File3.txt");

        Composite folder1 = new Composite("Folder1");
        Composite folder2 = new Composite("Folder2");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1);  // nested folder

        folder2.showDetails();
    }
}
