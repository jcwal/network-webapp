$(function() {
	var code = 'edit-segmentresource';
	var viewModel = ko.mapping.fromJS({
		id : '',
		type : 'A',
		tarea : '',
		tsegment : '',
		tusage : '',
		taccess : '',
		tvlanCode : '',
		tvlanName : '',
		tstartIp : '',
		tendIp : '',
		tipSize : '',
		tmask : '',
		tgateway : '',
		tgatewayType : '',
		tkeepIps : '',
		tkeepIpSize : '',
		tvalidateDate : '',
		tinvalidateDate : '',
		tline : '',
		telec : '',
		tport : '',
		tmainDns : '',
		tsecondDns : '',
		comments : ''
	});
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
				+ '/admin/network/segmentresource/get/' + currentId, function(
				data) {
			ko.mapping.updateFromJS(viewModel, data.returnObject);
		});
	}
});