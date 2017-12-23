import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

 class Node {  
    public int id;  
    public String name;  
    public Node leftChild;  
    public Node rightChild;  
  
    public Node(int id, String name) {  
        this.id = id;  
        this.name = name;  
    }  
}  
 public class bst {  
	    public Node root;  
	      
	    public Node find(int key){  
	        if(root == null){  
	            System.out.println("The tree is empty!");  
	            return null;  
	        }  
	        Node current = root;  
	        while(current.id != key){  
	            if(key > current.id)  
	                current = current.rightChild;  
	            else  
	                current = current.leftChild;  
	            if(current == null)  
	                return null;  
	        }  
	        return current;  
	    }  
	      
	    public boolean insert(Node node){  
	        if(root == null){  
	            root = node;  
	            return true;  
	        }  
	        //树中不允许插入重复的数据项  
	        if(this.find(node.id) != null){  
	            System.out.println("Node with id '" +  
	                    node.id + "' has already existed!");  
	            return false;  
	        }  
	        Node current = root;  
	        while(current != null){  
	            if(node.id > current.id){  
	                if(current.rightChild == null){  
	                    current.rightChild = node;  
	                    return true;  
	                }  
	                current = current.rightChild;  
	            }else{  
	                if(current.leftChild == null){  
	                    current.leftChild = node;  
	                    return true;  
	                }  
	                current = current.leftChild;  
	            }  
	        }  
	        return false;  
	    }  
	      
	    //前序遍历  
	    public void preorder_iterator(Node node){  
	        System.out.print(node.id + " ");  
	        if(node.leftChild != null)  
	            this.preorder_iterator(node.leftChild);  
	        if(node.rightChild != null)  
	            this.preorder_iterator(node.rightChild);  
	    }  
	      
	    //中序遍历  
	    //中序遍历二叉搜索树将会得到包含二叉搜索树  
	    //所有数据项的有序数列  
	    public void inorder_iterator(Node node){  
	        if(node.leftChild != null)  
	            this.inorder_iterator(node.leftChild);  
	        System.out.print(node.id + " ");  
	        if(node.rightChild != null)  
	            this.inorder_iterator(node.rightChild);  
	    }  
	      
	    //后序遍历  
	    public void postorder_iterator(Node node){  
	        if(node.leftChild != null)  
	            this.postorder_iterator(node.leftChild);  
	        if(node.rightChild != null)   
	            this.postorder_iterator(node.rightChild);  
	        System.out.print(node.id + " ");  
	    }  
	      
	    //获取树（子树）中的最小节点  
	    public Node getMinNode(Node node){  
	        if(this.find(node.id) == null){  
	            System.out.println("Node dosen't exist!");  
	            return null;  
	        }  
	        if(node.leftChild == null)  
	            return node;  
	        Node current = node.leftChild;  
	        while(current.leftChild != null)  
	            current = current.leftChild;  
	        return current;  
	    }  
	      
	    //获取树（子树）中的最大节点  
	    public Node getMaxNode(Node node){  
	        if(this.find(node.id) == null){  
	            System.out.println("Node dosen't exist!");  
	            return null;  
	        }  
	        if(node.rightChild == null)  
	            return node;  
	        Node current = node.rightChild;  
	        while(current.rightChild != null)  
	            current = current.rightChild;  
	        return current;  
	    }  
	      
	    //删除节点需要分3种情况进行讨论  
	    public boolean delete(int key){  
	        if(root == null){  
	            System.out.println("The tree is empty!");  
	            return false;  
	        }  
	        Node targetParent = root;  
	        Node target = root;  
	        boolean isLeftChild = true;  
	        while(target.id != key){  
	            if(key > target.id){  
	                targetParent = target;  
	                target = target.rightChild;   
	                isLeftChild = false;  
	            }else{  
	                targetParent = target;  
	                target = target.leftChild;  
	                isLeftChild = true;  
	            }  
	            if(target == null)  
	                break;  
	        }  
	        if(target == null){  
	            System.out.println("Node dosen't exist!"   
	                    + "Can not delete.");  
	            return false;  
	        }  
	        //被删除节点为叶子节点  
	        if(target.leftChild == null &&  
	                target.rightChild == null){  
	            if(target.id == root.id){  
	                root = null;  
	                return true;  
	            }  
	            if(isLeftChild)  
	                targetParent.leftChild = null;  
	            else  
	                targetParent.rightChild = null;  
	        }  
	        //被删除节点有1个子节点  
	        //被删除节点只有右子节点  
	        else if(target.leftChild == null &&   
	                target.rightChild != null){  
	            if(target.id == root.id){  
	                root = root.rightChild;  
	                return true;  
	            }  
	            if(isLeftChild)  
	                targetParent.leftChild = target.rightChild;  
	            else  
	                targetParent.rightChild = target.rightChild;  
	        }  
	        //被删除节点只有左子节点  
	        else if(target.leftChild != null &&   
	                target.rightChild == null){  
	            if(target.id == root.id){  
	                root = root.leftChild;  
	                return true;  
	            }  
	            if(isLeftChild)  
	                targetParent.leftChild = target.leftChild;  
	            else  
	                targetParent.rightChild = target.leftChild;  
	        }  
	        //被删除节点有左右子节点，先找到后续节点，将，然后将后续节点插入至待删除节点的位置  
	        else{  
	            Node followingNode = this.getFollowingNode(target);  
	            if(target.id == root.id)  
	                root = followingNode;  
	            else if(isLeftChild)  
	                targetParent.leftChild = followingNode;  
	            else  
	                targetParent.rightChild = followingNode;  
	            followingNode.leftChild = target.leftChild;  
	            followingNode.rightChild = target.rightChild;  
	        }  
	        return true;  
	    }  
	      
	    //获取被删除节点的后续节点  
	    private Node getFollowingNode(Node node2Del){  
	        Node nodeParent = node2Del;  
	        //只有被删除节点有左右子节点时，才会调用该方法  
	        //这里直接调用rightChild是没有问题的  
	        Node node = node2Del.rightChild;  
	        while(node.leftChild != null){  
	            nodeParent = node;  
	            node = node.leftChild;  
	        }  
	        if(node.id != node2Del.rightChild.id)  
	            nodeParent.leftChild = node.rightChild;  
	        else  
	            nodeParent.rightChild = node.rightChild;  
	        return node;  
	    } 
	    public static void main (String[] args) {
	  	  bst bst3 = new bst(); 
	  	  //String []num = new String[100];
	  	  ArrayList<String> list = new ArrayList<String>();
	        File file = new File("/Users/dengzeyu/Desktop/123.txt");
	        BufferedReader reader = null;
	        try {
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	                // 显示行号
	                System.out.println("line " + line + ": " + tempString);
	                //String[] sArray=tempString.split(tempString, ' ');
	           list.add(tempString);
	                line++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        
	        }
	        for(int  i=0;    i<list.size();    i++)    {
	      	  String s = list.get(i);
	      	  String[] sArray=s.split(" ");
	      	  System.out.println(s);
	      	  //System.out.println(sArray[1]);
	      	  for(int  q=0;  q<sArray.length;q++) {
	          	  //System.out.println(sArray[q]);
	          	  bst3.insert(Integer.parseInt(sArray[q]));
	            }
	      	  //(Integer.parseInt());  
	        }
	        Scanner inp = new Scanner(System.in);
	        System.out.println("plz input a number: ");
	  		String input1 = inp.next();
	  		int mum = Integer.parseInt(input1);
	  	  bst3.contains(mum)；
	  		bst3.insert(mum);
	    }
	  	  }
//public class bst {
//	public static TreeNode root;
//	 
//    public void BinarySearchTree() {
//        this.root = null;
//    }
// class TreeNode{
//	 int value;
//	 TreeNode left;
//	 TreeNode right;
//	 public TreeNode(int value) {
//		 this.value = value;
//		 left = null;
//		 right = null;
//	 }
//	 
// }
//
//  public TreeNode insert (int key) {
//	    // 新增节点
//	    TreeNode newNode = new TreeNode(key);
//	    // 当前节点
//	    TreeNode current = root;
//	    // 上个节点
//	    TreeNode parent  = null;
//	    // 如果根节点为空
//	    System.out.println(key); 
//	    if (current == null) {
//	        root = newNode;
//	        return newNode;
//	    }
//	    while (true) {
//	        parent = current;
//	        if (key < current.value) {
//	            current = current.left;
//	            if (current == null) {
//	                parent.left = newNode;
//	                return newNode;
//	            }
//	        } else {
//	            current = current.right;
//	            if (current == null) {
//	                parent.right = newNode;
//	                return newNode;
//	            }
//	        }
//	    }
//	    
//	}
//  public boolean insert(Node node){  
//      if(root == null){  
//          root = node;  
//          return true;  
//      }  
//      //树中不允许插入重复的数据项  
//      if(this.find(node.id) != null){  
//          System.out.println("Node with id '" +  
//                  node.id + "' has already existed!");  
//          return false;  
//      }  
//      Node current = root;  
//      while(current != null){  
//          if(node.id > current.id){  
//              if(current.rightChild == null){  
//                  current.rightChild = node;  
//                  return true;  
//              }  
//              current = current.rightChild;  
//          }else{  
//              if(current.leftChild == null){  
//                  current.leftChild = node;  
//                  return true;  
//              }  
//              current = current.leftChild;  
//          }  
//      }  
//      return false;  
//  }  
//  public TreeNode contains (int key) {
//	    TreeNode current = root;
//	    while (current != null
//	            && key != current.value) {
//	        if (key < current.value )
//	            current = current.left;
//	        else
//	            current = current.right;
//	    }
//	    return current;
//	}
//  
//  public TreeNode delete (int key) {
//      TreeNode parent  = root;
//      TreeNode current = root;
//      boolean isLeftChild = false;
//      // 找到删除节点 及 是否在左子树
//      while (current.value != key) {
//          parent = current;
//          if (current.value > key) {
//              isLeftChild = true;
//              current = current.left;
//          } else {
//              isLeftChild = false;
//              current = current.right;
//          }
//
//          if (current == null) {
//              return current;
//          }
//      }
//
//      // 如果删除节点左节点为空 , 右节点也为空
//      if (current.left == null && current.right == null) {
//          if (current == root) {
//              root = null;
//          }
//          // 在左子树
//          if (isLeftChild == true) {
//              parent.left = null;
//          } else {
//              parent.right = null;
//          }
//      }
//      // 如果删除节点只有一个子节点 右节点 或者 左节点
//      else if (current.right == null) {
//          if (current == root) {
//              root = current.left;
//          } else if (isLeftChild) {
//              parent.left = current.left;
//          } else {
//              parent.right = current.left;
//          }
//
//      }
//      else if (current.left == null) {
//          if (current == root) {
//              root = current.right;
//          } else if (isLeftChild) {
//              parent.left = current.right;
//          } else {
//              parent.right = current.right;
//          }
//      }
//      // 如果删除节点左右子节点都不为空
//      else if (current.left != null && current.right != null) {
//          // 找到删除节点的后继者
//          TreeNode successor = getDeleteSuccessor(current);
//          if (current == root) {
//              root = successor;
//          } else if (isLeftChild) {
//              parent.left = successor;
//          } else {
//              parent.right = successor;
//          }
//          successor.left = current.left;
//      }
//      return current;
//  }
//  public TreeNode getDeleteSuccessor(TreeNode deleteNode) {
//      // 后继者
//      TreeNode successor = null;
//      TreeNode successorParent = null;
//      TreeNode current = deleteNode.right;
//
//      while (current != null) {
//          successorParent = successor;
//          successor = current;
//          current = current.left;
//      }
//
//      // 检查后继者(不可能有左节点树)是否有右节点树
//      // 如果它有右节点树,则替换后继者位置,加到后继者父亲节点的左节点.
//      if (successor != deleteNode.right) {
//          successorParent.left = successor.right;
//          successor.right = deleteNode.right;
//      }
//
//      return successor;
//  }

            
	  //readFile("/Users/dengzeyu/Desktop/123.txt");
//  public static void readfile(String file){
////      try{
////          FileReader fr = new FileReader(file);
////          int ch = 0;
////          while((ch=fr.read())!=-1){//fr.read()读取一个字节，判断此字节的值为-1表示读到文件末尾了。
////              System.out.println((char)ch);
////          }
////      }catch(IOException e){
////          e.printStackTrace();
////      }
//  
//  try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
//
//		/* 读入TXT文件 */
//		//String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
//		File filename = new File(file); // 要读取以上路径的input。txt文件
//		InputStreamReader reader = new InputStreamReader(
//				new FileInputStream(filename)); // 建立一个输入流对象reader
//		BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
//		String line = "";
//		line = br.readLine();
//		while (line != null) {
//			line = br.readLine();
//			//System.out.println(line);// 一次读入一行数据
//		}
//		
//
////		/* 写入Txt文件 */
////		File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
////		writename.createNewFile(); // 创建新文件
////		BufferedWriter out = new BufferedWriter(new FileWriter(writename));
////		out.write("我会写入文件啦\r\n"); // \r\n即为换行
////		out.flush(); // 把缓存区内容压入文件
////		out.close(); // 最后记得关闭文件
//
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//  }
//  public static void readFile(String fileName) {
//      File file = new File(fileName);
//      BufferedReader reader = null;
//      try {
//          System.out.println("以行为单位读取文件内容，一次读一整行：");
//          reader = new BufferedReader(new FileReader(file));
//          String tempString = null;
//          int line = 1;
//          // 一次读入一行，直到读入null为文件结束
//          while ((tempString = reader.readLine()) != null) {
//              // 显示行号
//              System.out.println("line " + line + ": " + tempString);
//              line++;
//          }
//          reader.close();
//      } catch (IOException e) {
//          e.printStackTrace();
//      } finally {
//          if (reader != null) {
//              try {
//                  reader.close();
//              } catch (IOException e1) {
//              }
//          }
//      }
//  }


