var tempPriority = ["", "", ""]
	var tempIndex = 0;
	var fakePriority1 = document.getElementById("fakePriority1").value;
	var fakePriority2 = document.getElementById("fakePriority2").value;
	var realPriorityMost = document.getElementById("realPriorityMost").value;

	if((fakePriority1.length > 0) && (fakePriority2.length > 0)) {
		
		document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority1 + "," + fakePriority2;
		
	}
	else if (fakePriority1.length > 0) {
		
		document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority1;
	}
	else if (fakePriority2.length > 0) {
		document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority2;
	}
	
	var newPriorityMost = document.getElementById("realPriorityMost").value;
	
	for(var i = 0; i < newPriorityMost.length; ++i) {
		
		if(newPriorityMost[i] != ",") {
			
			tempPriority[tempIndex] += newPriorityMost[i];
		}
		else if (newPriorityMost[i] == ","){
			
			tempIndex = tempIndex + 1;
			continue;
		}
	
	}
	
	document.getElementById("realPriorityMost").value = tempPriority[0];
	document.getElementById("fakePriority1").value = tempPriority[1];
	document.getElementById("fakePriority2").value = tempPriority[2];
	
	// ---------------
	
	var tempPriority = ["", "", ""]
	var tempIndex = 0;
	var fakePriority3 = document.getElementById("fakePriority3").value;
	var fakePriority4 = document.getElementById("fakePriority4").value;
	var realPriorityMiddle = document.getElementById("realPriorityMiddle").value;

	if((fakePriority3.length > 0) && (fakePriority4.length > 0)) {
		
		document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority3 + "," + fakePriority4;
		
	}
	else if (fakePriority3.length > 0) {
		
		document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority3;
	}
	else if (fakePriority4.length > 0) {
		document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority4;
	}
	
	var newPriorityMiddle = document.getElementById("realPriorityMiddle").value;
	
	for(var i = 0; i < newPriorityMiddle.length; ++i) {
		
		if(newPriorityMiddle[i] != ",") {
			
			tempPriority[tempIndex] += newPriorityMiddle[i];
		}
		else if (newPriorityMiddle[i] == ","){
			
			tempIndex = tempIndex + 1;
			continue;
		}
	
	}
	
	document.getElementById("realPriorityMiddle").value = tempPriority[0];
	document.getElementById("fakePriority3").value = tempPriority[1];
	document.getElementById("fakePriority4").value = tempPriority[2];

	// ------------
	
	var tempPriority = ["", "", ""]
	var tempIndex = 0;
	var fakePriority5 = document.getElementById("fakePriority5").value;
	var fakePriority6 = document.getElementById("fakePriority6").value;
	var realPriorityLeast = document.getElementById("realPriorityLeast").value;

	if((fakePriority5.length > 0) && (fakePriority6.length > 0)) {
		
		document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority5 + "," + fakePriority6;
		
	}
	else if (fakePriority5.length > 0) {
		
		document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority5;
	}
	else if (fakePriority6.length > 0) {
		document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority6;
	}
	
	var newPriorityLeast = document.getElementById("realPriorityLeast").value;
	
	for(var i = 0; i < newPriorityLeast.length; ++i) {
		
		if(newPriorityLeast[i] != ",") {
			
			tempPriority[tempIndex] += newPriorityLeast[i];
		}
		else if (newPriorityLeast[i] == ","){
			
			tempIndex = tempIndex + 1;
			continue;
		}
	
	}
	
	document.getElementById("realPriorityLeast").value = tempPriority[0];
	document.getElementById("fakePriority5").value = tempPriority[1];
	document.getElementById("fakePriority6").value = tempPriority[2];
	
	function setPriority() {
		
		var tempPriority = ["", "", ""]
		var tempIndex = 0;
		var fakePriority1 = document.getElementById("fakePriority1").value;
		var fakePriority2 = document.getElementById("fakePriority2").value;
		var realPriorityMost = document.getElementById("realPriorityMost").value;

		if((fakePriority1.length > 0) && (fakePriority2.length > 0)) {
			
			document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority1 + "," + fakePriority2;
			
		}
		else if (fakePriority1.length > 0) {
			
			document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority1;
		}
		else if (fakePriority2.length > 0) {
			document.getElementById("realPriorityMost").value = realPriorityMost + "," + fakePriority2;
		}
		
		var newPriorityMost = document.getElementById("realPriorityMost").value;
		
		for(var i = 0; i < newPriorityMost.length; ++i) {
			
			if(newPriorityMost[i] != ",") {
				
				tempPriority[tempIndex] += newPriorityMost[i];
			}
			else if (newPriorityMost[i] == ","){
				
				tempIndex = tempIndex + 1;
				continue;
			}
		
		}
		
		document.getElementById("fakePriority1").value = tempPriority[1];
		document.getElementById("fakePriority2").value = tempPriority[2];
		
		var tempPriority = ["", "", ""]
		var tempIndex = 0;
		var fakePriority3 = document.getElementById("fakePriority3").value;
		var fakePriority4 = document.getElementById("fakePriority4").value;
		var realPriorityMiddle = document.getElementById("realPriorityMiddle").value;

		if((fakePriority3.length > 0) && (fakePriority4.length > 0)) {
			
			document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority3 + "," + fakePriority4;
			
		}
		else if (fakePriority3.length > 0) {
			
			document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority3;
		}
		else if (fakePriority4.length > 0) {
			document.getElementById("realPriorityMiddle").value = realPriorityMiddle + "," + fakePriority4;
		}
		
		var newPriorityMiddle = document.getElementById("realPriorityMiddle").value;
		
		for(var i = 0; i < newPriorityMiddle.length; ++i) {
			
			if(newPriorityMiddle[i] != ",") {
				
				tempPriority[tempIndex] += newPriorityMiddle[i];
			}
			else if (newPriorityMiddle[i] == ","){
				
				tempIndex = tempIndex + 1;
				continue;
			}
		
		}
		
		document.getElementById("fakePriority3").value = tempPriority[1];
		document.getElementById("fakePriority4").value = tempPriority[2];
		
		var tempPriority = ["", "", ""]
		var tempIndex = 0;
		var fakePriority5 = document.getElementById("fakePriority5").value;
		var fakePriority6 = document.getElementById("fakePriority6").value;
		var realPriorityLeast = document.getElementById("realPriorityLeast").value;

		if((fakePriority5.length > 0) && (fakePriority6.length > 0)) {
			
			document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority5 + "," + fakePriority6;
			
		}
		else if (fakePriority5.length > 0) {
			
			document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority5;
		}
		else if (fakePriority6.length > 0) {
			document.getElementById("realPriorityLeast").value = realPriorityLeast + "," + fakePriority6;
		}
		
		var newPriorityLeast = document.getElementById("realPriorityLeast").value;
		
		for(var i = 0; i < newPriorityLeast.length; ++i) {
			
			if(newPriorityLeast[i] != ",") {
				
				tempPriority[tempIndex] += newPriorityLeast[i];
			}
			else if (newPriorityLeast[i] == ","){
				
				tempIndex = tempIndex + 1;
				continue;
			}
		
		}
		
		document.getElementById("fakePriority5").value = tempPriority[1];
		document.getElementById("fakePriority6").value = tempPriority[2];
		
	}