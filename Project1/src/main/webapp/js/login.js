    
        //excute when page is fully loaded
		$(document).ready(function() {

            
            function noticeRegistered(){
                /*
                Desc:
                    GET: http://localhost/?registered=1   
                    
                    add a text notice user they just registered a account
                    Redirected from registere page
                */
                
				//get current the url
                var t = window.location.search.substr(1);
                if (t.split("registered")[1]){

                    t = t.split("registered")[1].split("=")[1];
                }
				if (t =="1"){
					$("#registered").text("Registered");
				}
            }
			noticeRegistered();	
            

            


		});