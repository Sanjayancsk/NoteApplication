<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<form:form method="post" modelAttribute="note">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="title">Title</form:label>
			<form:input path="title" type="text" class="form-control"
				required="required" />
			<form:errors path="title" cssClass="text-warning" />
		</fieldset>

		<fieldset class="form-group">
			<form:label path="targetDate">Created Date</form:label>
			<form:input path="targetDate" type="text" class="form-control"
				required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="detail">Description</form:label>
			<form:input path="detail" type="text" class="form-control"
				required="required" />
			<form:errors path="detail" cssClass="text-warning" />
		</fieldset>

		<button type="submit" class="btn btn-success">Create Note</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>