<#-- $Id: viewlog.ftl 3512 2012-08-23 01:12:33Z wilson $ -->
<#assign code="accesslog" />
<div class="tableform">	
	<div class="division" id="network_detail_1">
		<table cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
					<th><label>IP地址：</label></th>
					<td>
						${(network.ip)?default("&nbsp;")}
					</td>
					<th><label>IP类型：</label></th>
					<td>
						<span data-bind="param: 'network_type_list', code2value: '${network.type}' ">&nbsp;</span>						
					</td>
				</tr>
				<tr data-bind="visible: type()=='A' || type()=='B' ">
					<th><label>MAC地址：</label></th>
					<td>
						${(network.tmac)?default("&nbsp;")}
					</td>
					<th><label>设备类型：</label></th>
					<td>
						<#if network.tgroup?exists>
						<span data-bind="param: 'network_group_list', code2value: '${(network.tgroup)?default("")}' ">&nbsp;</span>
						<#else>
							${(network.tgroup)?default("&nbsp;")}
						</#if>	
					</td>
				</tr>
				<tr data-bind="visible: type()=='A' || type()=='B' ">
					<th><label>设备型号：</label></th>
					<td>
						${(network.tmodel)?default("&nbsp;")}
					</td>
					<th><label>设备名称：</label></th>
					<td>
						${(network.tname)?default("&nbsp;")}
					</td>
				</tr>
				<tr>
					<th><label>应用系统：</label></th>
					<td>
						${(network.tapplication)?default("&nbsp;")}
					</td>
					<th><label>操作系统：</label></th>
					<td>
						${(network.toperation)?default("&nbsp;")}
					</td>
				</tr>
				<tr>
					<th><label>用途：</label></th>
					<td colspan="3">
						${(network.tusage)?default("&nbsp;")}
					</td>							
				</tr>
				<tr>
					<th><label>网络区域：</label></th>
					<td>
						${(network.tarea)?default("&nbsp;")}
					</td>
					<th><label>所在机房：</label></th>
					<td>
						${(network.troom)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='A' || type()=='B' ">
					<th><label>机架位置：</label></th>
					<td>
						${(network.tposition)?default("&nbsp;")}
					</td>
					<th><label>配线架号：</label></th>
					<td>
						${(network.tdist)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='A' || type()=='B' ">
					<th><label>交换机IP：</label></th>
					<td>
						${(network.tswitchIp)?default("&nbsp;")}
					</td>
					<th><label>交换机端口：</label></th>
					<td>
						${(network.tswitchPort)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='C' || type()=='D' ">
					<th><label>域名：</label></th>
					<td>
						${(network.tdomain)?default("&nbsp;")}
					</td>
					<th><label>VS IP：</label></th>
					<td>
						${(network.tvsIp)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='C' || type()=='D' ">
					<th><label>F5 IP：</label></th>
					<td>
						${(network.tf5Ip)?default("&nbsp;")}
					</td>
					<th><label>线路名称：</label></th>
					<td>
						${(network.tline)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='C' || type()=='D' ">
					<th><label>服务器IP：</label></th>
					<td>
						${(network.tserverIp)?default("&nbsp;")}
					</td>
					<th><label>内网发布端口：</label></th>
					<td>
						${(network.tinsidePort)?default("&nbsp;")}
					</td>
				</tr>
				<tr data-bind="visible: type()=='C' || type()=='D' ">
					<th><label>公网IP：</label></th>
					<td>
						${(network.toutsideIp)?default("&nbsp;")}
					</td>
					<th><label>公网发布端口</label></th>
					<td>
						${(network.toutsidePort)?default("&nbsp;")}
					</td>
				</tr>
				<tr>
					<th><label>备注：</label></th>
					<td colspan="3">
						${(network.comments)?default("&nbsp;")}
					</td>
				</tr>
			</tbody>
		</table>
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
				</tr>
			</thead>
			<tbody>
				<#list network.rents as rent>
				<tr>
					<td>${rent_index+1}</td>
					<td>${((rent.beginDate)?string(datePattern))?default("&nbsp;")}</td>
					<td>${((rent.endDate)?string(datePattern))?default("&nbsp;")}</td>
					<td>${(rent.applyman)?default("&nbsp;")}</td>
					<td>${(rent.chargeman)?default("&nbsp;")}</td>
					<td>${(rent.comments)?default("&nbsp;")}</td>
				</tr>
				</#list>
			</tbody>			
		</table>		
	</div>
	<script>
		(function(){
			var viewModel = ko.mapping.fromJS({
				type : '${network.type}'
			});
			ko.applyBindings(viewModel, $('#network_detail_1')[0]);
		})();
	</script>
</div>
