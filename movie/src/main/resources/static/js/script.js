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
				location.assign("/movie/")
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
	fn_loadBoard : function(){
		
	}
}

$(function(){
	order("asc");
})
function order(sort){
	if(sort=='asc'){
		$(".sortShow").html("점수 : 오름차순")
	} else if(sort =='desc'){
		$(".sortShow").html("점수 : 내림차순")
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