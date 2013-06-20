$(function() {
	var code = 'edit-networkresource';
	var viewModel = ko.mapping.fromJS({
		id : '',
		ip : '',
		type : 'A',
		tmac : '',
		tgroup : '',
		tmodel : '',
		tname : '',
		tapplication : '',
		tusage : '',
		toperation : '',
		tarea : '',
		troom : '',
		tposition : '',
		tswitchIp : '',
		tswitchPort : '',
		tdist : '',

		tdomain : '',
		tvsIp : '',
		tf5Ip : '',
		tinsidePort : '',
		toutsideIp : '',
		toutsidePort : '',
		tserverIp : '',
		tline : '',

		comments : '',
		rents : [],
		existedLength : 0
	});
	var rentResource = {
		id : '',
		applyman : '',
		chargeman : '',
		beginDate : '',
		endDate : '',
		comments : '',
		deleted : false
	};
	viewModel.onAddRentResource = function() {
		this.rents.push(ko.mapping.fromJS(rentResource));
		return false;
	};
	viewModel.onDeleteRentResource = function(detail) {
		detail.id() ? detail.deleted(true) : this.rents.remove(detail);
		return false;
	};
	var $content = $('#page-' + code);
	ko.applyBindings(viewModel, $content[0]);
	$content.data('viewModel', viewModel);
	var $form = $content.find('form:first');
	$.metadata.setType('attr', 'validate');
	$.validator.addMethod("regex", function(value, element, regexp) {
		return this.optional(element) || regexp.test(value);
	}, "请按照IP规则(x.x.x.x)输入。");
	var validator = $form.validate({
		submitHandler : function(form) {
			$(form).ajaxSubmit(
					{
						success : function(data) {
							if (data.success) {
								MessageBox.info('保存成功!', true);
								$(form).trigger('closeDialog');
							} else {
								var errors = {};
								$(data.validateErrors).each(function() {
									errors[this.element] = this.message;
								});
								validator.showErrors(errors);
								data.exceptionMessage
										&& MessageBox.error(
												data.exceptionMessage, true);
							}
						}
					});
		}
	});
	$form.find('.cancel-btn').click(function() {
		$(this).trigger('closeDialog');
	});
	var currentId = $form.attr('item-id');
	if (currentId) {
		$.getJSON($form.getContextPath()
				+ '/admin/network/networkresource/get/' + currentId, function(
				data) {
			ko.mapping.updateFromJS(viewModel, data.returnObject);
		});
	}
});