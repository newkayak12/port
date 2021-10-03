let members={

	fn_login: function (){
			let data = {
				membersUserId:$("#userId").val(),
				membersUserPassword:$("#userPassword").val(),
			};
			$.ajax({
				type:"POST",
				url:"/movie/api/members/login",
				dataType:"json",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(data),
			}).done(function(){
				alert("로그인 성공")
				// location.assign("/movie/")
				// history.back();
				var link = document.location.href; 
				location.assign(link);

			}).fail(function(){
				alert('로그인 실패')
			})
		},
	fn_logout: function(){
		location.assign("/movie/logout")
	},
	fn_enroll: function(){
		
		let data = {
			membersUserId:$("#enrollUserId").val(),
			membersUserPassword:$("#enrollUserPassword").val()
		}
		if(data.membersUserId.length>4 && data.membersUserPassword.length>4){
			$.ajax({
				type:"POST",
				url:"/movie/api/members/join",
				dataType:"json",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(data),
			}).done(function(id){
				// $("#enroll").css("display","none")
				$("#enroll").modal('hide')
				$("#login").modal('show')
				// $(".modal-backdrop").css("display","none")
				if(id>0){
					alert("회원가입 성공")
				}
			}).fail(function(){
				$("#enrollUserId").val("");
				$("#enrollUserPassword").val("");
				alert('이미 존재하는 아이디')
			})
		} else {
			alert("아이디! 비밀번호!")
		}
	}

}

let movie={
	fn_movie: function(type, sort){
		if(type=='order'){
			order(sort)
		} else if(type=='genre'){
			genre(sort)
		}
	},
	goMovie: function(number){
		console.log(number)
		location.assign('/movie/movieDetail?movieId='+number);
	}

}

let board = {
	paging : function(pageNo, movieId){
		location.assign("/movie/movieDetail?movieId="+movieId+"&cPage="+pageNo);
		// $.ajax({
		// 	type:"GET",
		// 	url:"/movie/api/members/"+movieId+"/"+pageNo,
		// }).done(function(data){
		// 	console.log(data[0])
		// 	$("#pageBar").html(data[1]);
		// 	console.log($("#boardContent-table").html())
		// 	$("#boardContent-table").html('asdasdasdfasdfasdf');
		// 	console.log("sss")
		// 	console.log($("#boardContent-table").html())
		// 	let thtr = $("<tr>")
		// 	.append($("<th>").attr("class","text-center").html("작성자"))
		// 	.append($("<th>").attr("class","text-center").html("내용"))
		// 	.append($("<th>").attr("class","text-center").html("점수"))
		// 	.append($("<th>").attr("class","text-center").html("작성일"))
		// 	$("#boardContent-table").append(thtr);
		// 	data[0].forEach((v,i)=>{
				
		// 		let tdtr = $("<tr>")
		// 		.append($("<td>").attr("class","text-center").html(v['members']['membersUserId']))
		// 		.append($("<td>").attr("class","text-center").html(v['movieBoardContent']))
		// 		.append($("<td>").attr("class","text-center").html(v['movieBoardScore']))
		// 		.append($("<td>").attr("class","text-center").html(v['movieBoardWriteDate']))
		// 		$("#boardContent-table").append(thtr);

		// 	})



		// }).fail(function(){

		// })
		
	},
	delete: function(){
		let data ={
			membersId : $("#deleteMembersId").val(),
			movieId : $("#deleteMovieId").val(),
			movieBoardId: $("#deleteMovieBoardId").val(),
			movieBoardPassword: $("#boardDeletePassword").val(),
		}
		$.ajax({
			type:"DELETE",
			url:"/movie/api/movieBoard/delete",
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(data)
		}).done(function(data){
			console.log(data)
			if(data!=0){
				location.assign("/movie/movieDetail?movieId="+data);
			} else {
				alert("삭제에 실패했습니다");
			}
		}).fail(function(){
			alert("삭제에 실패했습니다");
		})
	},
	write:function(){
		let data = {
			membersId : $("#writeMembersId").val(),
			movieId : $("#writeMovieId").val(),
			movieBoardContent: $("#contentWrite").val(),
			movieBoardPassword: $("#boardWritePassword").val(),
		}
		$.ajax({
			type:"POST",
			url:"/movie/api/movieBoard/write",
			data:"json",
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(data)
		}).done(function(data){
			console.log(data)
			if(data!=0){
				location.assign("/movie/movieDetail?movieId="+data);
			} else {
				alert("등록에 실패했습니다");
			}
		}).fail(function(data){
			alert("등록에 실패했습니다");
		})
		

	},
	modify:function(){
		let data = {
			membersId : $("#modifyMembersId").val(),
			movieId : $("#modifyMovieId").val(),
			movieBoardId: $("#modifyMovieBoardId").val(),
			movieBoardContent: $("#contentModify").val(),
			movieBoardPassword: $("#boardModifyPassword").val(),
		}
		
		$.ajax({
			type:"PUT",
			url:"/movie/api/movieBoard/modify",
			dataType:"json",
			contentType:"application/json; charset=utf-8",
			data:JSON.stringify(data),

		}).done(function(data){
			console.log(data)
			if(data!=0){
				location.assign("/movie/movieDetail?movieId="+data);
			} else {
				alert("수정에 실패했습니다");
			}
		}).fail(function(){
				alert("수정에 실패했습니다.")
		})
	},
	modifyPre:function(membersId,  movieBoardId, movieId){
		console.log(membersId+":"+  movieId+":"+ movieBoardId)
		$("#modifyMembersId").val(membersId)
		$("#modifyMovieId").val(movieId)
		$("#modifyMovieBoardId").val(movieBoardId)
		
	},deletePre:function(membersId,  movieBoardId, movieId){
		console.log(membersId+":"+  movieId+":"+ movieBoardId)
		$("#deleteMembersId").val(membersId)
		$("#deleteMovieId").val(movieId)
		$("#deleteMovieBoardId").val(movieBoardId)
	},writePre:function(membersId, movieId){
		$("#writeMembersId").val(membersId)
		$("#writeMovieId").val(movieId)
	}
}

let actor={
	showActor:function(actorName, actorPicture, actorBirth){
		$("#modalActorPicture").attr("src","./img/"+actorPicture)
		$("#modalActorName").html(actorName)
		$("#modalActorBirth").html(actorBirth)
	}
}


$(function(){
	order("desc");
})
function order(sort){
	if(sort=='asc'){
		$(".sortShow").html("점수 : 낮은 순서")
	} else if(sort =='desc'){
		$(".sortShow").html("점수 : 높은 순서")
	}
	$.ajax({
		type:"GET",
		url:"/movie/api/movie/order/"+sort,
	}).done(function(data){
		 
		draw(data)
	}).fail(function(){

	})
}
function genre(sort){
	if(sort=='action'){
		$(".sortShow").html("장르 : 액션")
	}else if(sort=='thriller'){
		$(".sortShow").html("장르 : 스릴러")
	}else if(sort=='comic'){	
		$(".sortShow").html("장르 : 코미디")
	}else if(sort=='romantic'){
		$(".sortShow").html("장르 : 로맨틱")
	}
	$.ajax({
		type:"GET",
		url:"/movie/api/movie/genre/"+sort,
	}).done(function(data){
		draw(data)
	}).fail(function(){

	})

}
function draw (arr){
	$("#root").html("")
	arr.forEach((v,i) => {
		let div = $("<div>").attr({"class":"col-4 m-4 poster cursor", "onclick":"movie.goMovie("+v['movieId']+")"});
		let photoDiv = $("<div>").attr("class","cover-img");
		let photo = $("<img>").attr("src","./img/"+v['moviePoster'])
		let content = $("<div>").attr("class","cover").html(v['movieContent'])
		
		$("#root").append(div.append(photoDiv.append(photo)).append(content));
	})
}