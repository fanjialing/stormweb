(function($){
	$.fn.myPlugin = function(options){
		run.init(this);
		var dataarray = [];
		dataarray.push(run.title(options));
		dataarray.push(run.show(options));
		run.start(this,dataarray);
	}
	
	var run = {
			init:function($this){
				$this.css(
						{
						
						'min-height':'20px',
						'height':'400px',
						'margin': '0px auto',
						'margin-bottom' :'20px',
						'margin-left' :'0px',
						'border':'1px solid rgb(203,203,203)',
						//'box-shadow': '0 1px 2px #ECF5FF inset,0 -1px 0 #C4E1FF inset,0 -2px 3px #ECF5FF inset',
						//'background': '-webkit-linear-gradient(top,#ECF5FF,	#C4E1FF)',
						'border-radius': '3px',
						'padding':'5',
						
				});
			},
			start:function($this,dataarray){
				var starts = [];
				starts.push("<table class='tablelist'>");
				starts.push(dataarray);
				starts.push("</table>");
				$this.append(starts.join(''));
			},
			title:function(options){
				var titles = [];
				if(options.columns){
					titles.push("<thead><tr>");
					for(var i=0;i<options.columns.length;i++){
						if(options.columns[i].sort){
							titles.push("<th><i class='sort'><img src='images/px.gif' /></i>"+options.columns[i].display+"</th>");
						}else{
							titles.push( "<th>"+options.columns[i].display+"</th>")
						}

					}
					titles.push("</thead>");
					return titles.join('');
				}
			},
			show:function(options){
				var shows = [];
				if(options.url){
					// 加载json 数据
					shows.push("<tbody");
					for(var i=0;i<options.url.length;i++){
						if(i%2==0){
							shows.push( "<tr>");
						}else{
							shows.push("<tr class='odd'>");
						}
						shows.push( "<td>"+options.url[i].name+"</td>");
						shows.push("<td>"+options.url[i].value+"</td>");
						shows.push("</tr>");
					}
					shows.push("</tbody>");
					return shows.join('');
				}
			}
	
	}
	
	
})(jQuery)

