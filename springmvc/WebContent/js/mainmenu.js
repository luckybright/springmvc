$(function(){
	$(document).click(function(event){
		$(".popup_menu").fadeOut();
	});
	var menudata=[{"name":"文件","url":[{"name":"1","url":"url1"},{"name":"2","url":"url2"},{"name":"3","url":"url3"},{"name":"4","url":"url4"}]}, {"name":"编辑","url":[{"name":"a","url":"url1"},{"name":"b","url":"url2"},{"name":"c","url":"url3"},{"name":"d","url":"url4"}]}];
	var i = 0;
	var mainmenu = $("#mainmenu");
	var m_ul = $("<div></div>");
	m_ul.addClass("menu_ul");
	for (;i<menudata.length;i++){
		var m_li = $("<div></div>");
		m_li.addClass("menu_li");
		var m_label = $("<label></label>");
		m_label.text(menudata[i].name);
		m_li.append(m_label);
		addPopupMenu(m_li,menudata[i].url);
		
		m_li.click(function(e){
			$(".popup_menu").fadeOut();
			var menuBar = $(this).find("ul");
			menuBar.css("left",$(this).offset().left);
			menuBar.css("top",$(this).offset().top + $(this).height());
			menuBar.fadeIn();
			e.stopPropagation();
			//alert(menuBar.html());
		});
		m_ul.append(m_li);
	}
	mainmenu.append(m_ul);
	//document.write(mainmenu.html());
});
function addPopupMenu(parent,data){
	var i = 0;
	var menuBar = $("<ul></ul>");
	menuBar.addClass("popup_menu");
	
	for (;i<data.length;i++){
		var menuItemLi = $("<li><a></a></li>");
		var menuItem = menuItemLi.find("a");
		menuItem.attr("href",data[i].url);
		menuItem.text(data[i].name);
		menuBar.append(menuItemLi);
	}
	
	parent.append(menuBar);
}
function isObj(str){
	if(str === null || typeof str === 'undefined')
	{
	    return false;
	}
	return typeof str === 'object';
}
function isArray(obj){
    return (typeof obj=='object')&&obj.constructor==Array; 
} 