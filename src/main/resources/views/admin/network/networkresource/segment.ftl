<@layout.ajaxContent title="创建IP段 -[$Revision: 3569 $]" scripts="admin/network/networkresource/segment.js">
	<#assign code="create-segment" />
	<@layout.content_main>	
	<div id="page-${code}" class="tableform">
		<form id="form-${code}" action="${base}/admin/network/networkresource/savesegment" method="post">
			<div class="division">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<th><label>IP段(x.x.x)：</label></th>
							<td colspan="3">
								<input type="text" name="segment" maxlength="11" validate="{required:true,rangelength:[5,11],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){2}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />								
							</td>							
						</tr>
						<tr>
							<th><label>IP类型：</label></th>
							<td colspan="3">
								<select name="type" data-bind="options: $Param('network_type_list','${base}'), optionsText: 'label', optionsValue:'code', value: type" style="width: 185px;" validate="required:true"/>
							</td>
						</tr>							
					</tbody>
				</table>
			</div>
			<div class="table-action">
				<button type="submit" class="btn btn-primary">
					<span><span>保存</span></span>
				</button>
				<button type="button" class="btn btn-secondary cancel-btn">
					<span><span>关闭</span></span>
				</button>
			</div>
		</form>		
	</div>
	</@layout.content_main>
</@layout.ajaxContent>