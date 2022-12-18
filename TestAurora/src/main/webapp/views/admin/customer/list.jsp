<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/common/taglib.jsp"%>
<div class="page-content-wrapper">
	<div class="page-content">
		<div class="row">
			<div class="col-md-12">
				<!-- BEGIN EXAMPLE TABLE PORTLET-->
				<div class="portlet box grey-cascade">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-globe"></i>Quản lý khách hàng
						</div>
						<div class="tools">
							<a href="javascript:;" class="collapse"> </a> <a
								href="#portlet-config" data-toggle="modal" class="config"> </a>
							<a href="javascript:;" class="reload"> </a> <a
								href="javascript:;" class="remove"> </a>
						</div>
					</div>
					<div class="portlet-body">
						<div class="table-toolbar">
							<!-- Hiển thị thông báo -->
							<%@ include file="/common/info.jsp"%>
							<!-- Kết thúc hiển thị thông báo -->
							<div class="row">
								<div class="col-md-3">
									<div class="row">
										<div class="col-md-9">
											<form action="#" method="post" enctype="multipart/form-data">
												<br />
												<div class="form-group" hidden="hidden">
													<label for="id">Customer ID:</label> <input type="text"
														name="id" value="${customer.id}"
														id="id" class="form-control" readonly />
												</div>
												<div class="form-group">
													<label for="name">Customer Name:</label> <input
														type="text" class="form-control" name="name"
														id="name" value="${customer.name }" />
												</div>
												<div class="form-group">
													<label for="image">Images:</label> <input type="file"
														class="form-control" name="image" id="image"
														value="${customer.image}" />
												</div>
												<div class="form-group">
													<label for="address">Address:</label> <input type="text"
														class="form-control" name="address" id="address"
														value="${customer.address}" />
												</div>
												<div class="form-group">
													<label for="email">Email:</label> <input type="text"
														class="form-control" name="email" id="email"
														value="${customer.address}" />
												</div>
												<div class="form-group">
													<label for="phone">Phone:</label> <input type="text"
														class="form-control" name="phone" id="phone"
														value="${employee.phone}" />
												</div>
												<div class="form-group">
													<label for="password">Password:</label> <input
														type="text" class="form-control" name="password"
														value="${customer.password }" id="password" />
												</div>
												<div class="form-group">
													<label for="isRole">Roles:</label> <input type="text"
														class="form-control" name="isRole" id="isRole"
														value="3" readonly />
												</div>
												<div class="form-group">
													<label for="active">Active:</label> <input type="text"
														class="form-control" name="active" id="active"
														value="${customer.active}" />
												</div>
												<br />
												<hr>
												<div class="form-group">
													<button class="btn green"
														formaction="<c:url value="/admin-customer/create"/>">
														Create <i class="fa fa-plus"></i>
													</button>
													<button class="btn btn-warning"
														formaction="<c:url value="/admin-customer/update"/>">
														Update <i class="fa fa-edit"></i>
													</button>
													<br /> <br />
													<button class="btn btn-danger"
														formaction="<c:url value="/admin-customer/delete"/>">
														Delete <i class="fa fa-trash"></i>
													</button>
													<button class="btn btn-success"
														formaction="${pageContext.request.contextPath }/admin-customer/reset">
														Reset <i class="fa fa-undo"></i>
													</button>
												</div>
											</form>
										</div>
									</div>
								</div>

								<div class="col-md-9" style="padding-right: 25px">
									<div class="row">
										<div class="col-md-6"></div>
										<div class="col-md-6">
											<div class="btn-group pull-right">
												<button class="btn dropdown-toggle" data-toggle="dropdown">
													Tools <i class="fa fa-angle-down"></i>
												</button>
												<ul class="dropdown-menu pull-right">
													<li><a href="#"> Print </a></li>
													<li><a href="#"> Save as PDF </a></li>
													<li><a href="#"> Export to Excel </a></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="row">
										<table class="table table-striped table-bordered table-hover"
											id="sample_2">
											<thead>
												<tr>
													<th>Ảnh đại diện</th>
													<th>Tên khách hàng</th>
													<th>Địa chỉ</th>
													<th>Email</th>
													<th>Số điện thoại</th>
													<th>Mật khẩu</th>
													<th>Quyền</th>
													<th>Trạng thái</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${customers}">
													<tr class="odd gradeX"/>
														<td><c:url
																value="/image?fname=customer/${item.image!=null?item.image:'uploads/abc.jpg'}"
																var="imgUrl"></c:url> <img width="50px" height="50px"
															src="${imgUrl}"></td>
														<td>${item.name }</td>
														<td>${item.address }</td>
														<td>${item.email }</td>
														<td>${item.phone }</td>
														<td>${item.password }</td>
														<td>Customer</td>
														
														<td>${item.active }</td>
														<td><a
															href="<c:url value='/admin-customer/edit?userId=${item.id }'/>"
															class="center">Edit</a> | <a
															href="<c:url value='/admin-customer/delete?userId=${item.id }'/>"
															class="center">Delete</a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- END EXAMPLE TABLE PORTLET-->
			</div>
		</div>
	</div>
</div>

