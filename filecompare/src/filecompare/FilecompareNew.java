package filecompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilecompareNew {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileInput1 = null;
		String fileInput2 = null;
		
		
		//Compare all decision document with merged analysis and decision document
		//Result : unmerged decision documents - save this file (unmerged_decision_uris.txt)
		/*fileInput1 = "D:/input/new/lexismaroc_decision_MA.txt";
		fileInput2 = "D:/input/new/merged_analysis+decision_document_decisionUris.txt";*/
		
		//Compare unmerged decision documents with search response 
		//Result : all unmerged decision documents are present in search response
		/*fileInput1 = "D:/input/new/unmerged_decision_uris.txt";
		fileInput2 = "D:/input/new/searchqueryresponse.txt";*/
				
		
		//Compare merged analysis document with search response
		//Result: all merged analysis documents are present in search response
		/*fileInput1 = "D:/input/new/merged_analysis+decision_document_analysisUris.txt";
		fileInput2 = "D:/input/new/searchqueryresponse.txt";*/
				
		//Compare search response with merged analysis document 
		//Result: 2118 documents missing - save this file (missing_analysisORdecision_document.txt)
		/*fileInput1 = "D:/input/new/searchqueryresponse.txt";
		fileInput2 = "D:/input/new/merged_analysis+decision_document_analysisUris.txt";*/
		
		//Compare missing_analysisORdecision_document with unmerged decision document
		//Result: 125 documents are missing. These missing documents are Analysis documents. - save this file (missing_analysis_document.txt)
		/*fileInput1 = "D:/input/new/missing_analysisORdecision_document.txt";
		fileInput2 = "D:/input/new/unmerged_decision_uris.txt";*/
		
		
		//Compare unmerged decision document with missing_analysisORdecision_document 
		//Result: 0 files are missing. so all unmerged decision uris are present in search response
		/*fileInput1 = "D:/input/new/unmerged_decision_uris.txt";
		fileInput2 = "D:/input/new/missing_analysisORdecision_document.txt";*/
				
		
		//Compare missing_analysis_document.txt with search response
		//Result: all present in search response
		/*fileInput1 = "D:/input/new/missing_analysis_document.txt";
		fileInput2 = "D:/input/new/searchqueryresponse.txt";*/
		
		
		/*fileInput1 = "D:/input/new/all_documents.txt";
		fileInput2 = "D:/input/new/searchqueryresponse.txt";*/
		
		
		//find duplicate
		fileInput2 = "D:/input/new/merged_analysis+decision_document_analysisUris.txt";
				
		
		//get corresponding decision url
		fileInput1 = "D:/input/new/merged_analysis+decision_document_decisionUris.txt";
		//fileInput2 = "D:/input/new/inputFile/indexes.txt";
		
	    List<String> fileList1 = readFile(fileInput1);
		List<String> fileList2 = readFile(fileInput2);
		
		/*System.out.println("Compare result");
		printList(compare(fileList2,fileList1));
		*/
		
		/*System.out.println("missing result");
		printList(missing(fileList1,fileList2));*/
		List<String> allduplicateIndexes = duplicateFind(fileList2);
		List<String> correspondingdecisions = getIndex(fileList1,allduplicateIndexes);
		printList(correspondingdecisions);
		//printList(getIndex(fileList1,fileList2));
		
	}
	
	public static List<String> duplicateFind(List<String> list) {
		
		List<String> duplicateItems = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			for(int j=1;j<list.size();j++) {
				
				if(i!=j && list.get(i).equals(list.get(j))) {
					//duplicateItems.add("index "+i+" uri: "+list.get(i));
					duplicateItems.add(String.valueOf(i)+"zxy"+list.get(i));
					//duplicateItems.add(list.get(i));
					break;
				}
			}
		}
		return duplicateItems;
	}
	
	public static List<String> getIndex(List<String> sourceList,List<String> indexList ){
		
		List<String> theindex = new ArrayList<>();
		String []content = null;
		
		for(int i=0;i<indexList.size();i++) {
			content = indexList.get(i).split("zxy");
			int index = Integer.parseInt(content[0]);
			theindex.add(sourceList.get(index)+" <> "+content[1]);
			content = null;
		}
		
		return theindex;
		
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
	
	public static List<String> missing(List<String> list1,List<String> list2){
		List<String> missingList = new ArrayList<>();
		boolean flag = false;
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list2.size();j++) {
				
				if(list1.get(i).equals(list2.get(j))) {
					flag=true;
					break;
				}
				
			}
			if(!flag) {
				missingList.add(list1.get(i));
			}
			else {
				flag = false;
			}
		}
		
		return missingList;
	}
	
}
