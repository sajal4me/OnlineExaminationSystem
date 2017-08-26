package com.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;








public class GetQuestion {
	
	
	private Object getCellValue(Cell cell)
	{
		switch(cell.getCellType())
		{
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue();
			case Cell.CELL_TYPE_NUMERIC:
				return cell.getNumericCellValue();
		}
		
		return null;
	}
	
	public List<QuestionContainer> getQuestionFromExcel(String path) throws IOException
	{
		int counter=0;
		List<QuestionContainer> questionList=new ArrayList<QuestionContainer>();
		FileInputStream fis=new FileInputStream(new File(path));
		
		Workbook workbook = new XSSFWorkbook(fis);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    
	    QuestionContainer question = null;
	 
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        if(nextRow!=null)
	        {
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        question=new QuestionContainer();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            if(nextCell!=null)
	            {
	            int columnIndex = nextCell.getColumnIndex();
	            
	            switch (columnIndex) {
	            case 0:
	                question.setQuestion(((String) getCellValue(nextCell)));
	                break;
	            case 1:
	            	question.setOptionA((((String) getCellValue(nextCell))));
	                break;
	            case 2:
	            	question.setOptionB((((String) getCellValue(nextCell))));
	                break;
	            case 3:
	            	question.setOptionC((((String) getCellValue(nextCell))));
	                break;
	            case 4:
	            	question.setOptionD((((String) getCellValue(nextCell))));
	                break;
	            case 5:
	            	question.setAnswer(((((Double) getCellValue(nextCell)))));
	                break;
	            	
	            }
	 
	 
	            }
	       
	        	} 
	    }
	        System.out.println(counter++);
	        questionList.add(question);
	    
	    fis.close();
	    }
	    return questionList;
	    
	}
	
	

}
