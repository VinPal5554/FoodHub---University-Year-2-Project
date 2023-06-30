// WORK IN PROGRESS
	// Code needed to iterate through each table data and check if they are a business or not
	// this can be differentiated since businesses have negative points which regular users cannot get to
	var totalRowCount = 0;
	var rowCount = 0;
	var table = document.getElementById("foodbanks");
	var rows = table.getElementsByTagName("tr");
		
	for(var i = 0; i < rows.length; ++i) {
		++totalRowCount;
			
		if(rows[i].getElementsByTagName("td").length > 0) {
			++rowCount;
		}
			
			
	}