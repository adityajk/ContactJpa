$(document).ready(function() {
	$('.dropdown-menu').find('form').click(function (e) {
		//console.log("hello");
	    e.stopPropagation();
	});
			
	$('.close').click( function() {
	    $('.alert-error').hide('fast');
	    $('.alert-success').hide('fast');
	});
			
	$("#signup").validate({
		rules:{
			firstName:"required",
			lastName:"required",
			gender:"required",
			email:{
					required:true,
					email: true
			},
			password:{
				required:true,
				minlength: 8
			},
			confirmPassword:{
				required:true,
				equalTo: "#passwd"
			},
			gender:"required"
			},
				
			errorClass: showErrorClass(),
			messages: {
				firstName: "Enter your first name",
				password: "Enter the password"
			}
				
	});	
			
	//$(window).resize(function() {
	//	$(".help-inline").css({"display": "block"});			
	//});
			
			
	$(".gender .btn").click(function() {		
	    // whenever a button is clicked, set the hidden helper
	    $("#gender").val($(this).val());
	});
			
	oTable = $('#table_id').dataTable({
		"bJQueryUI": true,
		"sPaginationType": "full_numbers"
	});
	
	$("#when").datepicker({ dateFormat: 'yy/mm/dd'});
	
	$('[rel=tooltip]').tooltip();
	
	$("[id^=delete_]","#allEvents").click(function() {
		var $this = $(this);		
		if($('i', this).hasClass('icon-trash')) {
			$('i', this).toggleClass('icon-trash icon-spinner icon-spin');	
			var id = $this.attr('id');
			var deleteId = id.split('_');
			var URL = "delete/row";
			var data = "{\"deleteId\":"+deleteId[1]+"}";		
			$.ajax({ type:"POST", url: URL, data: data, contentType: "application/json", dataType:"text",
				success: function(text) {$this.parent('td').parent('tr').hide('slow');$(".responseResult > .alert-success").css({"display":"block"});},
				error: function(xhr) {$(".responseResult").html(xhr.responseText);}
			});
		}	
		return false;
	});
});

function showErrorClass() {
	var breakPoint = 767;
	var viewPortWidth = window.innerWidth;
	//console.log("hello"+viewPortWidth);
	if(viewPortWidth > breakPoint) {
		return 'help-inline';
	} else {
		return 'help-block';		
	}
}