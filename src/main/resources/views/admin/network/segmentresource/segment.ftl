<@layout.ajaxContent title="创建IP段 -[$Revision: 3569 $]" scripts="admin/network/segmentresource/segment.js">
	<#assign code="create-segment" />
	<@layout.content_main>	
	<div id="page-${code}" class="tableform">
		<form id="form-${code}" action="${base}/admin/network/segmentresource/batchsegment" method="post">
			<input type="hidden" name="segmentId" value="${segment.id}" />
			<div class="division">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<#if segment.type == 'A'>
						<tr>
							<th><label>IP段(x.x.x)：</label></th>
							<td colspan="3">
								${segment.tsegment}																
							</td>							
						</tr>
						</#if>
						<tr>
							<th><label>起始IP：</label></th>
							<td>
								${segment.tstartIp}
							</td>
							<th><label>终止IP：</label></th>
							<td>
								${segment.tendIp}								
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