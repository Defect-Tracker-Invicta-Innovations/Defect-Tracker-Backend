package com.sgic.internal.employee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.sgic.internal.employee.entities.Designation;
import com.sgic.internal.employee.entities.Employee;

public class ExcelUtils {

	public static List<Employee> parseExcelFile(InputStream is) {
		try {
			Workbook workbook = new XSSFWorkbook(is);
			// 1. You can obtain a sheetIterator and iterate over it
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			while (sheetIterator.hasNext()) {
				Sheet sheet = sheetIterator.next();
			}

			// Getting the Sheet at index zero
			Sheet sheet = workbook.getSheetAt(0);

			// Create a DataFormatter to format and get each cell's value as String
			DataFormatter dataFormatter = new DataFormatter();

			// 1. You can obtain a rowIterator and columnIterator and iterate over them
			Iterator<Row> rowIterator = sheet.rowIterator();
			List<Employee> listEmployees = new ArrayList<Employee>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// Now let's iterate over the columns of the current row
				Iterator<Cell> cellIterator = row.cellIterator();
				Employee employee = new Employee();
				Designation designation = new Designation();
				int cellIndex = 0;
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String cellValue = dataFormatter.formatCellValue(cell);
					if (cellIndex == 0) { // Employee Id
						employee.setEmployeeId(cell.getStringCellValue());
					} else if (cellIndex == 1) { // First Name
						employee.setFirstName(cell.getStringCellValue());
					} else if (cellIndex == 2) { // Last Name
						employee.setLastName(cell.getStringCellValue());
					} else if (cellIndex == 3) { // Email
						employee.setEmail(cell.getStringCellValue());
					} else if (cellIndex == 4) { // Designation Id
						designation.setId((long) cell.getNumericCellValue());
						employee.setDesignation(designation);
					} else if (cellIndex == 5) { // ProfilePicture
						employee.setProfilePicturePath(cell.getStringCellValue());
					}

					cellIndex++;
					listEmployees.add(employee);
				}

			}

			// Close WorkBook
			workbook.close();

			// return list employees;
			return listEmployees;
		} catch (IOException e) {
			throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		}

	}

}