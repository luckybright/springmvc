$(function(){
	$("button").click(function(event){
		event.preventDefault();
		var tbody = $(".tableFormDataDiv table tbody");
		var row = tbody.find("tr:first");
		var newRow = $.extend(true, {}, row);
		newRow.find("input").val("");
		tbody.find("tr:last").after(newRow.html());
	});
});
