(function($){
	var page;
	var pagesize;
	var total;
	var url;
	var parm;
	$.fn.myPlugin = function(options){
		
		//初始化 config
		run.init(this,options);
		run.title(this,options);
		run.url(page,parm);
		return  run;
	}
	
	var run = {
			test:function(){
				alert('---')
			},
			init:function($this,options){
				$this.css(
						{
						
						'min-height':'20px',
						'height':$(window).height()-88-80,
						'margin': '0px auto',
						'margin-bottom' :'20px',
						'margin-left' :'0px',
						'border':'1px solid rgb(203,203,203)',
						//'box-shadow': '0 1px 2px #ECF5FF inset,0 -1px 0 #C4E1FF inset,0 -2px 3px #ECF5FF inset',
						//'background': '-webkit-linear-gradient(top,#ECF5FF,	#C4E1FF)',
						'border-radius': '3px',
						'padding':'5',
						
				});
				
				if(options.url){
					url = options.url;
				}
				if(options.pagesize){
					pagesize = options.pagesize;
				}
				if(options.page){
					page =options.page;
				}
			},
			title:function($this,options){
				var titles = [];
				if(options.columns){
					var table =  document.createElement("table");
					var tbody = document.createElement("tbody");
					tbody.id='tbody';
					table.className='tablelist';
					var thead = document.createElement("thead");
					var tr = document.createElement("tr");
					thead.appendChild(tr); 
					table.appendChild(thead); 
					table.appendChild(tbody); 
					$this[0].appendChild(table); 
					for(var i=0;i<options.columns.length;i++){
						
						if(options.columns[i].sort){
							var th = document.createElement("th");
							th.innerHTML=options.columns[i].display;
							var _i = document.createElement("i");
							var img = document.createElement("img");
							img.src='images/px.gif';
							_i.appendChild=(img);
							_i.className='sort';
							th.appendChild(_i);
							tr.appendChild(th); 
						}else{
							var th = document.createElement("th");
							th.innerHTML=options.columns[i].display;
							tr.appendChild(th); 
						}

					}
				}
			},
			url:function(page){
				var datajson;
				var data = {page:page,pagesize:pagesize};
				if(parm){
					data = {page:page,pagesize:pagesize,filter:parm};
				}
					// 加载json 数据
					$.ajax({
			  			url:url,
			  			type:'get',
			  			async:false,  //true:异步,false:同步
			  			data:data,
			  			dataType:'json',
			  			success:function(data){
			  				datajson = data;
			  				run.show(datajson);
			  			},
			  			error:function(){
			  				console.log('error');
			  			}
			  		});
			},
			setParm : function(parms){
				if(parms){
					console.log(parms)
					parm = parms ;
				}
			},
			reLoad : function(){
				run.url(page,parm) ;
			},
			show:function(data){
				if(data){
	  				

					total = data.Total;

					var totalPage = total % pagesize == 0 ? total / pagesize : parseInt(total/ pagesize) + 1;

					var offset =   pagesize * (page - 1);
					var beginpage = 1;
					var endpage = 10;

			 		if(parseInt(page) >= 7 )
			 		{
			 			beginpage=parseInt(page)-2;
			 			endpage = parseInt(page) +7;
			 		}
			 		if(endpage>=totalPage)
			 		{
			 			endpage=totalPage;
			 		}

					var totals = [] ;
					
					totals.push('<div class="message">共<i class="blue">'+total+'</i>条记录，当前显示第&nbsp;<i class="blue">'+page+'&nbsp;</i>页</div>');
					totals.push('');
					totals.push('<ul class="paginList">') ;
					totals.push('<li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>') ;
					for(var j=beginpage;j<=endpage;j++){
						if(page == j){
							totals.push('<li class="paginItem current"><a href="javascript:;"  >'+j+'</a></li>') ;
						}else{
							totals.push('<li class="paginItem"><a href="javascript:;"  >'+j+'</a></li>') ;
						}
					}
					totals.push('<li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>') ;
					totals.push('</ul>') ;
					$(".pagin").html(totals.join("")) ;
					$(".pagin ul li").click(function(){
							//上一页
							if($(this).index() == 0){
								console.log('上一页');
								if(page !=1)
								page--;

							}else
							//下一页
							if($(this).index() == $(".pagin ul li").length - 1){
								console.log('下一页');
								if(page !=endpage)
								page++;

							}else{
								page = $(this).text();

							}

						run.url(page,parm);
					});
					var tbody = document.getElementById("tbody");
					tbody.innerHTML= '';
					for(var i=0;i<data.Rows.length;i++){
						console.log(data.Rows[i]);
						var tr = document.createElement("tr");
						if(i%2==0){
							tbody.appendChild(tr);
						}else{
							tr.className='odd';
							tbody.appendChild(tr);
						}
						var td_id = document.createElement("td");
						var td_code = document.createElement("td");
						var td_name = document.createElement("td");

						td_id.innerHTML=data.Rows[i].id;
						td_code.innerHTML=data.Rows[i].userCode;
						td_name.innerHTML=data.Rows[i].userPwd;

						tr.appendChild(td_id);
						tr.appendChild(td_code);
						tr.appendChild(td_name);

					}
				}
			}
		
	}
	
	
})(jQuery)

