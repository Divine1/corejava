package filecompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String fileInput1 = null;
		String fileInput2 = null;
		
		/*fileInput1 = "D:/input/input1.txt";
		fileInput2 = "D:/input/input2.txt";*/
		
		fileInput1 = "D:/input/lexismaroc_decision_MA.txt";
		fileInput2 = "D:/input/searchqueryresponse.txt";
		
		List<String> fileList1 = readFile(fileInput1);
		List<String> fileList2 = readFile(fileInput2);
		
		/*Iterator<String> iterator = fileList2.iterator();
		List<String> itemExists = new ArrayList<>();
		List<String> itemNotExists = new ArrayList<>();*/
		
		/*while(iterator.hasNext()) {
			String item = iterator.next();
			if(fileList1.contains(item)){
				//System.out.println("true - "+item);
				itemExists.add(item);
			}else {
				itemNotExists.add(item);
				//System.out.println("false - "+item);
			}
		}*/
		
		
		/*System.out.println("Compare result");
		printList(compare(fileList1,fileList2));*/
		
		System.out.println("Compare result");
		printList(compare(fileList2,fileList1));
		
		/*System.out.println("item exists");
		printList(itemExists);*/
		
		//System.out.println("item not exists");
		//printList(itemNotExists);
	}
	
	public static List<String> readFile(String fileName) throws IOException{
		File file = new File(fileName);
		List<String> fileList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			//System.out.println(st+" - "+st.length());
			fileList.add(st);
		}
		br.close();
		
		return fileList;
			
	}
	public static void printList(List<String> list) {
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String item = iterator.next();			
			System.out.println(item);
		}
		System.out.println("item count "+list.size());
		
	}
	public static List<String> compare(List<String> list1,List<String> list2){
		List<String> equalList = new ArrayList<>();
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list2.size();j++) {
				
				if(list1.get(i).equals(list2.get(j))) {
					equalList.add(list1.get(i));
					break;
				}
				
			}
		}
		
		return equalList;
	}
}
