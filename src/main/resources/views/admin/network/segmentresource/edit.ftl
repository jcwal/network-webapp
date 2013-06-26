<@layout.ajaxContent title="<#if segmentId?exists>编辑IP段信息<#else>新增IP段信息</#if> -[$Revision: 3569 $]" scripts="admin/network/segmentresource/edit.js">
	<#assign code="edit-segmentresource" />
	<@layout.content_main>	
	<div id="page-${code}" class="tableform">
		<form id="form-${code}" item-id="${segmentId?if_exists}" action="${base}/admin/network/segmentresource/save" method="post">
			<input type="hidden" name="segment.id" data-bind="value: id" />
			<div class="division">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<th><label>IP段类型：</label></th>
							<td colspan="3">
								<select name="segment.type" data-bind="options: $Param('segment_type_list','${base}'), optionsText: 'label', optionsValue:'code', value: type" style="width: 185px;" validate="required:true"/>
							</td>
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>区域：</label></th>
							<td>
								<input type="text" name="segment.tarea" maxlength="255" data-bind="value: tarea" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>IP地址段：</label></th>
							<td>
								<input type="text" name="segment.tsegment" maxlength="50" data-bind="value: tsegment" validate="{required:true,rangelength:[7,13],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:X)$/}" style="width: 180px;" />
							</td>
						</tr>
						<tr data-bind="visible: type()=='B'">
							<th><label>线路名称：</label></th>
							<td>
								<input type="text" name="segment.tline" maxlength="255" data-bind="value: tline" validate="rangelength:[1,255]" style="width: 180px;" />
							</td>
							<th><label>电路编号：</label></th>
							<td>
								<input type="text" name="segment.telec" maxlength="255" data-bind="value: telec" validate="rangelength:[1,255]" style="width: 180px;" />
							</td>
						</tr>				
						<tr>
							<th><label>用途：</label></th>
							<td colspan="3">
								<input type="text" name="segment.tusage" maxlength="255" data-bind="value: tusage" validate="rangelength:[0,255]" style="width: 521px;" />
							</td>							
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>获取方式</label></th>
							<td colspan="3">
								<input type="text" name="segment.taccess" maxlength="255" data-bind="value: taccess" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>							
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>VLAN号：</label></th>
							<td>
								<input type="text" name="segment.tvlanCode" maxlength="255" data-bind="value: tvlanCode" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>VLAN名称：</label></th>
							<td>
								<input type="text" name="segment.tvlanName" maxlength="255" data-bind="value: tvlanName" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>起始IP：</label></th>
							<td>
								<input type="text" name="segment.tstartIp" maxlength="255" data-bind="value: tstartIp" validate="{required:true,rangelength:[7,115],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />
							</td>
							<th><label>终止IP：</label></th>
							<td>
								<input type="text" name="segment.tendIp" maxlength="255" data-bind="value: tendIp" validate="{required:true,rangelength:[7,115],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />								
							</td>
						</tr>
						<tr>
							<th data-bind="visible: type()=='B'"><label>端口：</label></th>
							<td data-bind="visible: type()=='B'">
								<input type="text" name="segment.tport" maxlength="255" data-bind="value: tport" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
							<th><label>IP地址数：</label></th>
							<td>
								<input type="text" name="segment.tipSize" maxlength="255" data-bind="value: tipSize" validate="rangelength:[1,255],number: true" style="width: 180px;" />								
							</td>
							<th data-bind="visible: type()=='A'"><label>保留IP数：</label></th>
							<td data-bind="visible: type()=='A'">
								<input type="text" name="segment.tkeepIpSize" maxlength="255" data-bind="value: tkeepIpSize" validate="rangelength:[1,255],number: true" style="width: 180px;" />
							</td>
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>保留IP地址：</label></th>
							<td colspan="3">
								<input type="text" name="segment.tkeepIps" maxlength="255" data-bind="value: tkeepIps" validate="rangelength:[0,500]" style="width: 180px;" />								
							</td>
						</tr>						
						<tr>
							<th><label>子网掩码：</label></th>
							<td>
								<input type="text" name="segment.tmask" maxlength="255" data-bind="value: tmask" validate="{required:true,rangelength:[7,115],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />
							</td>
							<th><label>网关：</label></th>
							<td>
								<input type="text" name="segment.tgateway" maxlength="255" data-bind="value: tgateway" validate="{required:true,rangelength:[7,115],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='A'">
							<th><label>启用日期：</label></th>
							<td>
								<input type="text" id="tvalidateDate" name="segment.tvalidateDate" data-bind="value: tvalidateDate, type: 'date' " autocomplete="off" class="Wdate" onFocus="WdatePicker({dateFmt:'${datePattern}', maxDate:'#F{$dp.$D(\'tinvalidateDate',{m:-1})}' })" style="width:180px" />
							</td>
							<th><label>取消日期：</label></th>
							<td>
								<input type="text" id="tinvalidateDate" name="segment.tinvalidateDate" data-bind="value: tinvalidateDate, type: 'date' " autocomplete="off" class="Wdate" onFocus="WdatePicker({dateFmt:'${datePattern}', minDate:'#F{$dp.$D(\'tvalidateDate',{m:1})}' })" style="width:180px" />								
							</td>
						</tr>						
						<tr data-bind="visible: type()=='B'">
							<th><label>主DNS：</label></th>
							<td>
								<input type="text" name="segment.tmainDns" maxlength="255" data-bind="value: tmainDns" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>备DNS：</label></th>
							<td>
								<input type="text" name="segment.tsecondDns" maxlength="255" data-bind="value: tsecondDns" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr>
							<th><label>备注：</label></th>
							<td colspan="3">
								<textarea name="segment.comments" rows="2" cols="50" data-bind="value: comments" validate="rangelength:[0,2048]" style="width: 521px;"></textarea>
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