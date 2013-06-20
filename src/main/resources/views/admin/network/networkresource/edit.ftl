<@layout.ajaxContent title="<#if networkId?exists>编辑医生信息<#else>新增医生信息</#if> -[$Revision: 3569 $]" scripts="admin/network/networkresource/edit.js">
	<#assign code="edit-networkresource" /><#assign subCode="edit-networkresource-rents" />
	<@layout.content_main>	
	<div id="page-${code}" class="tableform">
		<form id="form-${code}" item-id="${networkId?if_exists}" action="${base}/admin/network/networkresource/save" method="post">
			<input type="hidden" name="network.id" data-bind="value: id" />
			<div class="division">
				<table cellspacing="0" cellpadding="0" border="0">
					<tbody>
						<tr>
							<th><label>IP地址：</label></th>
							<td>
								<#if networkId?exists>
									<span data-bind="text: ip"></span>
									<input type="hidden" name="network.ip" data-bind="value: ip"/>
								<#else>
									<input type="text" name="network.ip" maxlength="50" data-bind="value: ip" validate="{required:true,rangelength:[7,115],regex:/^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/}" style="width: 180px;" />
								</#if>
							</td>
							<th><label>IP类型：</label></th>
							<td>
								<select name="network.type" data-bind="options: $Param('network_type_list','${base}'), optionsText: 'label', optionsValue:'code', value: type" style="width: 185px;" validate="required:true"/>
							</td>
						</tr>
						<tr data-bind="visible: type()=='A' || type()=='B' ">
							<th><label>MAC地址：</label></th>
							<td>
								<input type="text" name="network.tmac" maxlength="32" data-bind="value: tmac" validate="rangelength:[0,32]" style="width: 180px;" />
							</td>
							<th><label>设备类型：</label></th>
							<td>
								<select name="network.tgroup" data-bind="options: $Param('network_group_list','${base}'), optionsText: 'label', optionsCaption: '请选择...', optionsValue:'code', value: tgroup" style="width: 185px;"/>								
							</td>
						</tr>
						<tr data-bind="visible: type()=='A' || type()=='B' ">
							<th><label>设备型号：</label></th>
							<td>
								<input type="text" name="network.tmodel" maxlength="255" data-bind="value: tmodel" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>设备名称：</label></th>
							<td>
								<input type="text" name="network.tname" maxlength="255" data-bind="value: tname" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr>
							<th><label>应用系统：</label></th>
							<td>
								<input type="text" name="network.tapplication" maxlength="255" data-bind="value: tapplication" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>操作系统：</label></th>
							<td>
								<input type="text" name="network.toperation" maxlength="255" data-bind="value: toperation" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr>
							<th><label>用途：</label></th>
							<td colspan="3">
								<input type="text" name="network.tusage" maxlength="255" data-bind="value: tusage" validate="rangelength:[0,255]" style="width: 521px;" />
							</td>							
						</tr>
						<tr>
							<th><label>网络区域：</label></th>
							<td>
								<input type="text" name="network.tarea" maxlength="255" data-bind="value: tarea" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>所在机房：</label></th>
							<td>
								<input type="text" name="network.troom" maxlength="255" data-bind="value: troom" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='A' || type()=='B' ">
							<th><label>机架位置：</label></th>
							<td>
								<input type="text" name="network.tposition" maxlength="255" data-bind="value: tposition" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>配线架号：</label></th>
							<td>
								<input type="text" name="network.tdist" maxlength="255" data-bind="value: tdist" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='A' || type()=='B' ">
							<th><label>交换机IP：</label></th>
							<td>
								<input type="text" name="network.tswitchIp" maxlength="255" data-bind="value: tswitchIp" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>交换机端口：</label></th>
							<td>
								<input type="text" name="network.tswitchPort" maxlength="255" data-bind="value: tswitchPort" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='C' || type()=='D' ">
							<th><label>域名：</label></th>
							<td>
								<input type="text" name="network.tdomain" maxlength="255" data-bind="value: tdomain" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>VS IP：</label></th>
							<td>
								<input type="text" name="network.tvsIp" maxlength="255" data-bind="value: tvsIp" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='C' || type()=='D' ">
							<th><label>F5 IP：</label></th>
							<td>
								<input type="text" name="network.tf5Ip" maxlength="255" data-bind="value: tf5Ip" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>线路名称：</label></th>
							<td>
								<input type="text" name="network.tline" maxlength="255" data-bind="value: tline" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='C' || type()=='D' ">
							<th><label>服务器IP：</label></th>
							<td>
								<input type="text" name="network.tserverIp" maxlength="255" data-bind="value: tserverIp" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>内网发布端口：</label></th>
							<td>
								<input type="text" name="network.tinsidePort" maxlength="255" data-bind="value: tinsidePort" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr data-bind="visible: type()=='C' || type()=='D' ">
							<th><label>公网IP：</label></th>
							<td>
								<input type="text" name="network.toutsideIp" maxlength="255" data-bind="value: toutsideIp" validate="rangelength:[0,255]" style="width: 180px;" />
							</td>
							<th><label>公网发布端口</label></th>
							<td>
								<input type="text" name="network.toutsidePort" maxlength="255" data-bind="value: toutsidePort" validate="rangelength:[0,255]" style="width: 180px;" />								
							</td>
						</tr>
						<tr>
							<th><label>备注：</label></th>
							<td colspan="3">
								<textarea name="network.comments" rows="2" cols="50" data-bind="value: comments" validate="rangelength:[0,2048]" style="width: 521px;"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<h4>使用历史信息列表</h4>
			<table class="gridlist">	
				<thead>
					<tr>
						<th style="width:5%">序号</th>
						<th style="width:15%">开始时间</th>
						<th style="width:15%">结束时间</th>
						<th style="width:10%">申请人</th>
						<th style="width:10%">负责人</th>
						<th style="width:45%">备注</th>
						<th style="width:10%">&nbsp;</th>
					</tr>
				</thead>
				<tbody data-bind="template: { name: 'template-${subCode}' }"></tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<button type="button" class="btn btn-has-icon" data-bind="click: onAddRentResource">
				  				<span><span><i class="btn-icon"><@macula.themeImage src="bundle/btn_add.gif"/></i>新增借用</span></span>
				  			</button>
						</td>
					</tr>
				</tfoot>
			</table>
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
	<script type="text/x-jquery-tmpl" id="template-${subCode}">
	<#noparse>
		{{each(index,detail) rents}}
		<tr data-bind="visible: !detail.deleted()" class="row {{if index % 2 == 0}}odd{{else}}even{{/if}}">
			<td>
				<input type="hidden" name="network.rents[${index}].id" data-bind="value: detail.id" />
				<input type="hidden" name="network.rents[${index}].deleted" data-bind="value: (detail.deleted())?1:0" />
				<span>${index+1}</span>
			</td>
			<td>
				<input type="text" id="begin_${index}" name="network.rents[${index}].beginDate" data-bind="value: detail.beginDate, type: 'date' " autocomplete="off" class="Wdate" onFocus="WdatePicker({onpicking:function(dp){ $('#page-edit-networkresource').data('viewModel').rents()[${index}].beginDate(dp.cal.getNewDateStr()); }, dateFmt:'${datePattern}' {{if index > 0 }}, minDate:'#F{$dp.$D(\'end_${index-1}\',{m:1})}' {{/if}}, maxDate:'#F{$dp.$D(\'end_${index}\',{m:-1})}'})" style="width:100%" />				
			</td>
			<td>
				<input type="text" id="end_${index}"   name="network.rents[${index}].endDate"   data-bind="value: detail.endDate,   type: 'date' " autocomplete="off" class="Wdate" onFocus="WdatePicker({onpicking:function(dp){ $('#page-edit-networkresource').data('viewModel').rents()[${index}].endDate(dp.cal.getNewDateStr()); }, dateFmt:'${datePattern}',minDate:'#F{$dp.$D(\'begin_${index}\',{m:1})}' {{if (index+1) < rents().length }}, maxDate:'#F{$dp.$D(\'begin_${index+1}\',{m:-1})}' {{/if}} })" style="width:100%" />				
			</td>
			<td>
				<input type="text" name="network.rents[${index}].applyman" data-bind="value: detail.applyman" validate="required:true,rangelength:[1,255]" style="width:100%" />
			</td>
			<td>
				<input type="text" name="network.rents[${index}].chargeman" data-bind="value: detail.chargeman" validate="required:true,rangelength:[1,255]" style="width:100%" />
			</td>
			<td>
				<input type="text" name="network.rents[${index}].comments" data-bind="value: detail.comments" validate="rangelength:[0,255]" style="width:100%" />
			</td>
			<td><input type="button" value="删除" data-bind="click: function() { onDeleteRentResource(detail); }, clickBubble: false" /></td>
		</tr>
		{{/each}}
	</#noparse>
	</script>
	</@layout.content_main>
</@layout.ajaxContent>