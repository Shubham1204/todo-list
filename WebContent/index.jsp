<%@page import="jdk.management.resource.internal.TotalResourceContext"%>
<%@page import="java.util.ArrayList,com.shubham.todolist.model.todolist,java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDo List</title>
<link href="css/bootstrap.min.css" rel ="stylesheet">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<style>
	.hide{
	display: none;
	}
</style>
<script>
	function showsearch() {
		document.getElementById("search-box").classList.toggle('hide');
	}
</script>
</head>	
<body>
<div class="container-fluid">

	<h1 class="alert-info text-center">ToDo List</h1>
<%
if(session.getAttribute("uid")==null){
	response.sendRedirect("login.jsp");
}
%>
<div class="float-left"><h2>Welcome <%=session.getAttribute("uid") %></h2></div>
	<div class="float-right"><a href="logout">Logout</a></div>
	<br><br>
	<form action="todo" method="post">
	<div class='w-25 float-left pr-2'>
		<h2 class='text-center btn btn-outline-warning w-100 display-1'>Add New Task</h2>
		<div class='form-group'>
			<label>Id</label>
			<input class='form-control' type='text' <% if(request.getAttribute("updateresultid")!=null){
				%>value=<%=request.getAttribute("updateresultid")%>	<% }else{ } %> name='id' placeholder='Enter the ID'>
		</div>
		<div class='form-group'>
			<label>Task Name</label>
			<input class='form-control' type='text' name='taskname' <% if(request.getAttribute("updateresulttname")!=null){
				%>value=<%=request.getAttribute("updateresulttname")%>	<% }else{ } %> placeholder='Enter the Task Name'>
			
		</div>
		<div class='form-group'>
			<label>Desc</label>
			<input rows="10" cols="30" class='form-control' name='desc' <% if(request.getAttribute("updateresultdesc")!=null){
				%>value=<%=request.getAttribute("updateresultdesc")%>	<% }else{ } %> placeholder='Enter the desc'>
		</div>
		<div class='form-group'>
			<label>Start Date</label>
			<input class='form-control' type='date' name='startdate' <% if(request.getAttribute("updateresultsdate")!=null){
				%>value=<%=request.getAttribute("updateresultsdate")%>	<% }else{ } %> placeholder='Enter the Start Date'>
		</div>
		<div class='form-group'>
			<label>End Date</label>
			<input class='form-control' type='date' name='enddate' <% if(request.getAttribute("updateresultedate")!=null){
				%>value=<%=request.getAttribute("updateresultedate")%>	<% }else{ } %> placeholder='Enter the End Date'>
		</div>
		<div class='form-group'>
			<button type="submit" name="addtask" value="addtask" class='btn btn-primary'>ADD Task</button>
		 	<button type="button" data-toggle="modal" data-target="#mailModalCenter" class='btn btn-primary'>ADD Task & Send MAIL</button> 

<%-- type="submit" name="addtaskandmail" value="addtaskandmail" --%>
<!--Mail Modal -->
<div class="modal fade" id="mailModalCenter" tabindex="-1" role="dialog" aria-labelledby="mailModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Email</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      
        <div class='form-group'>
			<label>Sender Gmail ID</label>
			<input class='form-control' type="text" name='smail' placeholder='Enter the Senders Gmail ID'>
		</div>
		<div class='form-group'>
			<label>Senders Gmail Password</label>
			<input class='form-control' type="password" name='spwd' placeholder='Enter the Senders Gmail Password'>
		</div>
		<div class='form-group'>
			<label>Recievers Email ID</label>
			<input class='form-control' type="text" name='rmail' placeholder='Enter the recievers Mail'>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" name="addtaskandmail" value="addtaskandmail">Send Mail</button>
      </div>
    </div>
  </div>
</div>
		</div>
	</div>
	<div class='w-75 float-right pl-2'>
		<h2 class='text-center btn btn-outline-success w-100'>Tasks</h2>
		<div class='form-group'>
			<button type="button" class="btn btn-primary">Total tasks <span class="badge badge-light"><%=request.getAttribute("totallist") %></span>
			</button>
			<button type="button" class="btn btn-primary">Pending <span class="badge badge-light"><%=request.getAttribute("pending") %></span>
			</button>
			<button type="button" class="btn btn-primary">Complete <span class="badge badge-light"><%=request.getAttribute("complete") %></span>
			</button>
			<div class='float-right'>
			<a href="sort"><button type="button" name="sort-asc-btn" value="SortIt" class="btn btn-primary">Sort by ID <i class="fas fa-sort-numeric-up"></i>
			</button></a>
			
			<button type="button" onclick="showsearch()" class="btn btn-primary">Search <i class="fas fa-search"></i>
			</button>
			<div id="search-box" class="hide">
				<form action="/searchctrl">
					<input name="sid" type='text' placeholder='Type Id'>
					<button name="searchitbtn" value="SearchIt">Search it</button>
				</form>
			</div>
			</div>	
		</div>
		<% if(request.getAttribute("searchresult")!=null){%>
			<h1>Search result is <%=request.getAttribute("searchresult") %></h1> 
			<%
		}
		%>
		<%-- <h1>Search result is <%=request.getAttribute("searchresult") %></h1>  --%>
		<table class='table table-bordered'>
			<thead class='thead-dark'>
				<tr>
					<th>Task Id</th>
					<th>Task Name</th>
					<th>Task Desc</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<todolist> list = (ArrayList<todolist>)request.getAttribute("mydata");
					if(list!=null){
						for(todolist obj : list){
						%>
						<tr>
						<td><%=obj.getId() %></td>
						<td><%=obj.getTaskName() %></td>
						<td><%=obj.getDesc() %></td>
						<td><%=obj.getStartDate() %></td>
						<td><%=obj.getEndDate() %></td>
						<td>
							<ttd><a href="delete?id=<%=obj.getId() %>"><i class="fas fa-trash"></i></a></ttd>
							<ttd><a href="update?id=<%=obj.getId() %>"><i class="far fa-edit"></i></a></ttd>
							<%-- <ttd><a href="update?id=<%=obj.getId() %>"><button type="button" data-toggle="modal" data-target="#updateModalCenter" class='btn btn-primary'><i class="far fa-edit"></i></button></a></ttd> --%>
						</td>
						</tr>
						<% 
						}
					}
					else if(list==null){
						%>
						<tr>
						<td></td>
						<td></td>
						<td class='text-center'><h2>List is Empty</h2></td>
						<td></td>
						<td></td>
						</tr>
						<%
					}
				%>
			</tbody>
		</table>
	</div>
	</form>
</div>


<%-- type="submit" name="addtaskandmail" value="addtaskandmail"<%		int uid; 
		String utaskname;
		String udesc;
		LocalDate ustartdate;
		LocalDate uenddate;
				String updatelist = (String)request.getAttribute("updateresult");
					if(updatelist!=null){
						
						updatelist.
						for(todolist obj1 : updatelist){
							uid = obj1.getId();
							utaskname = obj1.getTaskName();
							udesc = obj1.getDesc();
							ustartdate = obj1.getStartDate();
							uenddate = obj1.getEndDate();%> --%>

						
						
<%-- <!--Update Modal -->
<div class="modal fade" id="updateModalCenter" tabindex="-1" role="dialog" aria-labelledby="updateModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Update</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <div class='form-group'>
			<label>Id</label>
			<input class='form-control' type='text' name='updateid' value=<%=request.getAttribute("updateresultid") %> placeholder='Enter the ID'>
		</div>
		<div class='form-group'>
			<label>Task Name</label>
			<input class='form-control' type='text' name='updatetaskname' value=<%=request.getAttribute("updateresulttname") %> placeholder='Enter the Task Name'>
		</div>
		<div class='form-group'>
			<label>Desc</label>
			<textarea rows="2" cols="30" class='form-control' name='updatedesc' value=<%=request.getAttribute("updateresultdesc") %> placeholder='Enter the desc'></textarea>
		</div>
		<div class='form-group'>
			<label>Start Date</label>
			<input class='form-control' type='date' name='updatestartdate' value=<%=request.getAttribute("updateresultsdate") %> placeholder='Enter the Start Date'>
		</div>
		<div class='form-group'>
			<label>End Date</label>
			<input class='form-control' type='date' name='updateenddate' value=<%=request.getAttribute("updateresultedate") %> placeholder='Enter the End Date'>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button class="btn btn-primary" type="submit" name="addtaskandmail" value="addtaskandmail">Update It</button>
      </div>
    </div>
  </div>
</div>
 --%>

<%-- <% 
						}	
					}
					else if(updatelist==null){
						System.out.println("can't update");
					}
%> --%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>