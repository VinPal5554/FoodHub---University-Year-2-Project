 var points20 = document.getElementById("Points20");
    var points50 = document.getElementById("Points50");
    var points100 = document.getElementById("Points100");
    
    var realDonation = document.getElementById("donations").value;
	
	document.getElementById("fakeDonation").value = "";
    	
    	points20.onclick = function() {
    		
    		var cost = 20;
    		var previousPoints = Number(document.getElementById("awardPoints").value);
    		var enteredData = document.getElementById("fakeDonation").value;
    		
    		document.getElementById("awardPoints").value =  previousPoints + cost;
    		
    			if ((document.getElementById("donations").value).length > 0) {
    			
    				document.getElementById("donations").value = document.getElementById("donations").value + "/" + enteredData;
    			}
    			else {
    				document.getElementById("donations").value = enteredData;
    			}
    			
    
    		
    	}
		points50.onclick = function() {
    		
    		var cost = 50;
    		var previousPoints = Number(document.getElementById("awardPoints").value);
    		var enteredData = document.getElementById("fakeDonation").value;
    		
    		document.getElementById("awardPoints").value =  previousPoints + cost;
    		
				if ((document.getElementById("donations").value).length > 0) {
    			
    				document.getElementById("donations").value = document.getElementById("donations").value + "/" + enteredData;
    			}
				else {
					document.getElementById("donations").value = enteredData;
				}
    		
    	}
		points100.onclick = function() {
	
		var cost = 100;
		var previousPoints = Number(document.getElementById("awardPoints").value);
		var enteredData = document.getElementById("fakeDonation").value;
	
		document.getElementById("awardPoints").value =  previousPoints + cost;
		
				if ((document.getElementById("donations").value).length > 0) {
			
					document.getElementById("donations").value = document.getElementById("donations").value + "/" + enteredData;
				}
				else {
					document.getElementById("donations").value = enteredData;
				}
	
		}
		