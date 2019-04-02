<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
		<table class="table table-striped">
			<caption>Your Notes are</caption>
			<thead>
				<tr>
					<th>Title</th>
					<th>Created Date</th>
					<th>Description</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${notes}" var="note">
					<tr>
						<td>${note.title}</td>
						<td><fmt:formatDate value="${note.targetDate}" pattern="dd/MM/yyyy"/></td>
						<td>${note.detail}</td>
						<td><a type="button" class="btn btn-success"
							href="/update-note?id=${note.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="/delete-note?id=${note.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<a class="button" href="/add-note">Add a New Note</a>
		</div>
	</div>
<%@ include file="common/footer.jspf" %>