package filecompare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Filecompare {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileInput1 = null;
		String fileInput2 = null;
		
		//compare all decisionURI's with searchresponse
		
		//fileInput1 = "D:/input/lexismaroc_decision_MA.txt";
		//fileInput2 = "D:/input/searchqueryresponse.txt";
		
		
		//compare merged decisionUri's with all decisionUri's = unmerged decision uri's
		/*fileInput1 = "D:/input/new_all_decision_docuris_having_links_to_analysis_document.txt";
		fileInput2 = "D:/input/lexismaroc_decision_MA.txt";*/
		
		
		//compare searchResponse with UnmergedDecisionUri's = searchResponse contains all unmergedDecision uri's
		/*fileInput1 = "D:/input/searchqueryresponse.txt";
		fileInput2 = "D:/input/missing_docs_frommerged_vs_ludovic.txt";*/
		
		
		//compare searchresponse with merged analysisUri's = unmerged analysis uri's 
		/*fileInput1 = "D:/input/searchqueryresponse.txt";
		fileInput2 = "D:/input/all_analysis_docuris_linked_to_decision.txt";
		*/
		
		
		//
		fileInput1 = "D:/input/missing_docs_frommerged_vs_ludovic.txt";
		fileInput2 = "D:/input/check/searchResponse_missing_comparedwith_mergedanalysisURI.txt";
		
		
		List<String> fileList1 = readFile(fileInput1);
		List<String> fileList2 = readFile(fileInput2);
		
		/*System.out.println("Compare result");
		printList(compare(fileList2,fileList1));
		*/
		
		System.out.println("missing result");
		printList(missing(fileList2,fileList1));
		
		
		
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
