package com.seminar.util;

import com.seminar.print.Csv;
import com.seminar.print.Html;
import com.seminar.print.Plain;

public class PrintFactory {

	private final Seminar _seminar;

	public PrintFactory(Seminar seminar) {
		_seminar = seminar;
	}

	public String printPlain() {
		return new Plain().print(_seminar);
	}

	public String printHtml() {
		return new Html().print(_seminar);
	}

	public String printCsv() {
		return new Csv().print(_seminar);
	}
	
	public static String printForm() {
		return "<!DOCTYPE html>                                                                                                                                 " +
			    "<html lang='en'>                                                                                                                                " +
			    "  <head>                                                                                                                                        " +
			    "    <meta charset='utf-8'>                                                                                                                      " +
			    "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
			    "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
			    "    <title>Seminar</title>                                                                                      								 " +
			    "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
			    "  </head>                                                                                                                                       " +
			    "  <body>                                                                                                                                        " +
			    "  	<div class='container'>                                                                                                                      " +
			    "  		<div class='row'>                                                                                                                        " +
			    "  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
			    "  				<h1 class='page-header text-center'>Add a course</h1>                                                                           " +
			    "				<form class='form-horizontal' role='form' method='post' action=''>                                                      		 " +
			    /*
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Location</label>                                                        " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='location' name='location' placeholder='City' value='' required='true'>" +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    */
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Course Name</label>                                                     " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='coursName' name='coursName' placeholder='Course Name' value='' required='true'>" +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Course Number</label>                                                   " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='number' name='courseNumber' min='1' max='5' class='form-control' id='courseNumber' placeholder='Course Number' value='' required='true'>" +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Course Description</label>                                                            " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='courseDescription' name='courseDescription' placeholder='Course Description' value='' required='true'>" +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    
			    "					<div class='form-group'>                                                                                                     " +
			    "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
			    "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "				</form>                                                                                                                          " +
			    "			</div>                                                                                                                               " +
			    "		</div>                                                                                                                                   " +
			    "	</div>                                                                                                                                       " +
			    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
			    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
			    "</body> "
			    ;
	}
	
}