package com.comcast.oscar.examples;

import java.io.FileNotFoundException;

import com.comcast.oscar.configurationfile.ConfigurationFile;
import com.comcast.oscar.configurationfile.ConfigurationFileException;
import com.comcast.oscar.configurationfile.ConfigurationFileExport;
import com.comcast.oscar.configurationfile.ConfigurationFileImport;
import com.comcast.oscar.test.TestDirectoryStructure;

/**
 * @bannerLicense
	Copyright 2015 Comcast Cable Communications Management, LLC<br>
	___________________________________________________________________<br>
	Licensed under the Apache License, Version 2.0 (the "License")<br>
	you may not use this file except in compliance with the License.<br>
	You may obtain a copy of the License at<br>
	http://www.apache.org/licenses/LICENSE-2.0<br>
	Unless required by applicable law or agreed to in writing, software<br>
	distributed under the License is distributed on an "AS IS" BASIS,<br>
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.<br>
	See the License for the specific language governing permissions and<br>
	limitations under the License.<br>


 * @author Maurice Garcia (maurice.garcia.2015@gmail.com)
 */


public class PrettyPrintTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		/***************************
		 * Text to Binary
		 ***************************/
		ConfigurationFileImport cfi = null;
		try {
			cfi = new ConfigurationFileImport(TestDirectoryStructure.fInputDirFileName("bsod.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ConfigurationFileException e) {
			e.printStackTrace();
		}
		
		ConfigurationFile cf = new ConfigurationFile(ConfigurationFile.DOCSIS_VER_30,cfi.getTlvBuilder());
		
		ConfigurationFileExport cfe =  new ConfigurationFileExport (cf);
		
		System.out.println(cfe.toPrettyPrint(ConfigurationFileExport.EXPORT_FOUND_TLV));
		System.out.println("+-------------------------------------------------------------------------------------------+");
		System.out.println(cfe.toPrettyPrint(ConfigurationFileExport.EXPORT_DEFAULT_TLV));

		System.out.println("+-------------------------------------------------------------------------------------------+");		
		System.out.println("+-------------------------------------------------------------------------------------------+");		
		System.out.println("+-------------------------------------------------------------------------------------------+");		
		System.out.println("+-------------------------------------------------------------------------------------------+");		

		/***************************
		 * Binary to Text
		 ***************************/
		cfe = new ConfigurationFileExport (TestDirectoryStructure.fInputDirFileName("bsod.cm"));
		
		//Does not Export Default TLVs
		System.out.println(cfe.toPrettyPrint(ConfigurationFileExport.EXPORT_FOUND_TLV));
		System.out.println("+-------------------------------------------------------------------------------------------+");		
		System.out.println(cfe.toPrettyPrint(ConfigurationFileExport.EXPORT_DEFAULT_TLV));
		
	}

}
