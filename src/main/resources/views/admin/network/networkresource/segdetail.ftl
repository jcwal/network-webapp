<#-- $Id: viewlog.ftl 3512 2012-08-23 01:12:33Z wilson $ -->
<#assign code="accesslog" />
<div class="tableform">	
	<div class="division">
	<#if segments?exists && segments?has_content>
	<#list segments as segment>
		<table id="segment_detail_${segment_index}" cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
					<th><label>IP段类型：</label></th>
					<td colspan="3">
						<span data-bind="param: 'segment_type_list', code2value: '${segment.type}' ">&nbsp;</span>						
					</td>
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>区域：</label></th>
					<td>
						${(segment.tarea)?default("&nbsp;")}
					</td>
					<th><label>IP地址段：</label></th>
					<td>
						${(segment.tsegment)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='B'">
					<th><label>线路名称：</label></th>
					<td>
						${(segment.tline)?default("&nbsp;")}
					</td>
					<th><label>电路编号：</label></th>
					<td>
						${(segment.telec)?default("&nbsp;")}
					</td>
				</tr>				
				<tr>
					<th><label>用途：</label></th>
					<td colspan="3">
						${(segment.tusage)?default("&nbsp;")}
					</td>							
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>获取方式：</label></th>
					<td colspan="3">
						${(segment.taccess)?default("&nbsp;")}
					</td>							
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>VLAN号：</label></th>
					<td>
						${(segment.tvlanCode)?default("&nbsp;")}
					</td>
					<th><label>VLAN名称：</label></th>
					<td>
						${(segment.tvlanName)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>起始IP：</label></th>
					<td>
						${(segment.tstartIp)?default("&nbsp;")}
					</td>
					<th><label>终止IP：</label></th>
					<td>
						${(segment.tendIp)?default("&nbsp;")}
					</td>
				</tr>
				<tr>
					<th data-bind="visible: type()=='B'"><label>端口：</label></th>
					<td data-bind="visible: type()=='B'">
						${(segment.tport)?default("&nbsp;")}								
					</td>
					<th><label>IP地址数：</label></th>
					<td>
						${(segment.tipSize)?default("&nbsp;")}								
					</td>
					<th data-bind="visible: type()=='A'"><label>保留IP数：</label></th>
					<td data-bind="visible: type()=='A'">
						${(segment.tkeepIpSize)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>保留IP地址：</label></th>
					<td colspan="3">
						${(segment.tkeepIps)?default("&nbsp;")}								
					</td>
				</tr>						
				<tr>
					<th><label>子网掩码：</label></th>
					<td>
						${(segment.tmask)?default("&nbsp;")}
					</td>
					<th><label>网关：</label></th>
					<td>
						${(segment.tgateway)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='A'">
					<th><label>启用日期：</label></th>
					<td>
					<#if (segment.tvalidateDate)?exists>
						${((segment.tvalidateDate)?string(datePattern))?default("&nbsp;")}
					<#else>
						&nbsp;
					</#if>
					</td>
					<th><label>取消日期：</label></th>
					<td>
						<#if (segment.tinvalidateDate)?exists>
						${((segment.tinvalidateDate)?string(datePattern))?default("&nbsp;")}
						<#else>
						&nbsp;
					</#if>								
					</td>
				</tr>						
				<tr data-bind="visible: type()=='B'">
					<th><label>主DNS：</label></th>
					<td>
						${(segment.tmainDns)?default("&nbsp;")}
					</td>
					<th><label>备DNS：</label></th>
					<td>
						${(segment.tsecondDns)?default("&nbsp;")}
					</td>
				</tr>
				<tr>
					<th><label>备注：</label></th>
					<td colspan="3">
						${(segment.comments)?default("&nbsp;")}
					</td>
				</tr>
			</tbody>
		</table>
		<script>
		(function(){
			var viewModel_${segment_index} = ko.mapping.fromJS({
				type : '${segment.type}'
			});
			ko.applyBindings(viewModel_${segment_index}, $('#segment_detail_${segment_index}')[0]);
		})();
	</script>
	</#list>	
	<#else>
		<h4>未找到相关IP段信息</h4>
	</#if>	
</div>