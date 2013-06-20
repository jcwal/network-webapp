package org.jcwal.so.network.service.impl;

import javax.annotation.PostConstruct;

import org.macula.base.data.vo.CriteriaType;
import org.macula.base.data.vo.DataType;
import org.macula.base.data.vo.FieldControl;
import org.macula.plugins.mda.finder.domain.FinderAction;
import org.macula.plugins.mda.finder.domain.FinderColumn;
import org.macula.plugins.mda.finder.domain.FinderDataSet;
import org.macula.plugins.mda.finder.domain.FinderParam;
import org.macula.plugins.mda.finder.domain.FinderSchema;
import org.macula.plugins.mda.finder.domain.FinderTabView;
import org.macula.plugins.mda.finder.service.FinderSchemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NetworkSchemaRegistory {

	public static final String NETWORKRESOURCE_SCHEMA = "NETWORKRESOURCE_SCHEMA";
	public static final String PATIENT_SCHEMA = "PATIENT_SCHEMA";
	public static final String VISIT_SCHEMA = "VISIT_SCHEMA";

	@Autowired
	private FinderSchemaService memorySchemaService;

	@PostConstruct
	public void registry() {
		memorySchemaService.add(createNetworkResourceSchema());
	}

	private FinderSchema createNetworkResourceSchema() {
		FinderSchema schema = new FinderSchema();
		schema.setCode(NETWORKRESOURCE_SCHEMA);
		schema.setTitle("IP资源管理");
		schema.setRelativePath("admin/network/networkresource/list");

		FinderDataSet finderDataSet = new FinderDataSet("NETWORK_RESOURCE_SET");
		schema.setFinderDataSet(finderDataSet);

		FinderParam param = null;
		FinderColumn column = new FinderColumn();

		column.setLabel("编号");
		column.setColumn("id");
		column.setName("id");
		column.setType(DataType.Long);
		column.setPkey(true);
		column.setVisible(false);
		schema.addColumn(column);

		column = new FinderColumn();
		column.setLabel("IP地址");
		column.setColumn("IP");
		column.setName("IP");
		column.setType(DataType.String);
		column.setVisible(true);
		column.setWidth(100);
		schema.addColumn(column);

		param = new FinderParam(column, null);
		param.setEnableSearch(true);
		param.setEnableFilter(true);
		param.setDefaultCriteriaType(CriteriaType.StartWith);
		param.setFieldControl(FieldControl.Text);
		schema.addParam(param);

		column = new FinderColumn();
		column.setLabel("类型");
		column.setColumn("TYPE");
		column.setName("TYPE");
		column.setType(DataType.String);
		column.setVisible(true);
		column.setWidth(100);
		schema.addColumn(column);

		param = new FinderParam(column, "network_type_list");
		param.setEnableSearch(true);
		param.setEnableFilter(true);
		param.setDefaultCriteriaType(CriteriaType.Equals);
		param.setFieldControl(FieldControl.Text);
		schema.addParam(param);

		column = new FinderColumn();
		column.setLabel("可用");
		column.setColumn("tusable");
		column.setName("tusable");
		column.setType(DataType.Boolean);
		column.setVisible(true);
		column.setWidth(100);
		schema.addColumn(column);

		param = new FinderParam(column, "network_usable_list");
		param.setEnableSearch(true);
		param.setEnableFilter(true);
		param.setDefaultCriteriaType(CriteriaType.Equals);
		param.setFieldControl(FieldControl.Text);
		schema.addParam(param);

		column = new FinderColumn();
		column.setLabel("设备类型");
		column.setColumn("tgroup");
		column.setName("tgroup");
		column.setType(DataType.String);
		column.setVisible(true);
		column.setWidth(100);
		schema.addColumn(column);

		param = new FinderParam(column, "network_group_list");
		param.setEnableSearch(true);
		param.setEnableFilter(true);
		param.setDefaultCriteriaType(CriteriaType.Equals);
		param.setFieldControl(FieldControl.Text);
		schema.addParam(param);

		column = new FinderColumn();
		column.setLabel("用途");
		column.setColumn("tusage");
		column.setName("tusage");
		column.setType(DataType.String);
		column.setVisible(true);
		column.setWidth(100);
		schema.addColumn(column);

		param = new FinderParam(column, null);
		param.setEnableSearch(true);
		param.setEnableFilter(true);
		param.setDefaultCriteriaType(CriteriaType.Contains);
		param.setFieldControl(FieldControl.Text);
		schema.addParam(param);

		schema.setEnableFilter(true);
		schema.setEnableSearch(true);

		FinderAction action = new FinderAction();
		action.setLabel("批量新增IP资源");
		action.setHref("admin/network/networkresource/segment");
		action.setTarget("dialog::{title: '批量新增IP资源', width:'720',height:'280'}");
		schema.addAction(action);

		action = new FinderAction();
		action.setLabel("新增IP资源");
		action.setHref("admin/network/networkresource/create");
		action.setTarget("dialog::{title: '新增IP资源', width:'720',height:'700'}");
		schema.addAction(action);

		action = new FinderAction();
		action.setLabel("编辑IP资源");
		action.setHref("admin/network/networkresource/edit");
		action.setTarget("dialog::{title: '编辑IP资源', width:'720',height:'700'}");
		action.setMaxRowSelected(1);
		action.setMinRowSelected(1);
		schema.addAction(action);

		action = new FinderAction();
		action.setLabel("删除IP资源");
		action.setHref("admin/network/networkresource/delete");
		action.setConfirm("您确定删除该IP资源吗？");
		action.setTarget("command");
		action.setMinRowSelected(1);
		schema.addAction(action);

		//		FinderDetailView detailView = new FinderDetailView();
		//		detailView.setCode("networkresourcedetail");
		//		detailView.setLabel("IP资源使用明细");
		//		detailView.setHref("admin/network/networkresource/detail");
		//		schema.addDetailView(detailView);

		FinderTabView tabView = new FinderTabView();
		tabView.setCode("insideips");
		tabView.setLabel("内网办公区");
		tabView.setFilter(" type = 'A' ");
		tabView.setOrder(0);
		schema.addTabView(tabView);

		tabView = new FinderTabView();
		tabView.setCode("insideserver");
		tabView.setLabel("内网服务器区");
		tabView.setFilter(" type = 'B' ");
		tabView.setOrder(1);
		schema.addTabView(tabView);

		tabView = new FinderTabView();
		tabView.setCode("ousideserver");
		tabView.setLabel("F5发布区");
		tabView.setFilter(" type = 'C' ");
		tabView.setOrder(2);
		schema.addTabView(tabView);

		tabView = new FinderTabView();
		tabView.setCode("ousideserver");
		tabView.setLabel("互联网发布区");
		tabView.setFilter(" type = 'D' ");
		tabView.setOrder(3);
		schema.addTabView(tabView);

		tabView = new FinderTabView();
		tabView.setCode("allips");
		tabView.setLabel("所有IP资源");
		tabView.setFilter(" 1=1 ");
		tabView.setOrder(4);
		schema.addTabView(tabView);

		return schema;
	}

}
