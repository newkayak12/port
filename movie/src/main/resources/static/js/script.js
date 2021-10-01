let members={

	fn_login: function (){
			let data = {
				membersUserId:$("#userId").val(),
				membersUserPassword:$("#userPassword").val(),
			};
			$.ajax({
				type:"POST",
				url:"/movie/api/members/posts",
				dataType:"json",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(data),
			}).done(function(){
				alert("로그인 성공")
				location.assign("/movie/")
			}).fail(function(){
				alert('로그인 실패')
			})
		}
}