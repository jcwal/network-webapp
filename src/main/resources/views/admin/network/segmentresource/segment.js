$(function() {
	var code = 'create-segment';

	var $content = $('#page-' + code);
	ko.applyBindings(ko.mapping.fromJS({
		type : 'A'
	}), $content[0]);

	var $form = $content.find('form:first');
	$.metadata.setType('attr', 'validate');
	$.validator.addMethod("regex", function(value, element, regexp) {
		return this.optional(element) || regexp.test(value);
	}, "请按照IP段规则(x.x.x)输入。");
	var validator = $form.validate({
		submitHandler : function(form) {
			$(form).ajaxSubmit(
					{
						success : function(data) {
							if (data.success) {
								MessageBox.info('成功生成' + data.returnObject
										+ '个IP资源!', true);
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
});
