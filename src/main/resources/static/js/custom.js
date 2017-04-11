$('input[name="profileTypeRadio"]').on('change', function(){
    if ($(this).id()=='userType1') {
         
        //change to "show update"
         $("#displayNameText").text("show update");
        
    } else  {
       
        $("#displayNameText").text("show Overwritten");
    }
});