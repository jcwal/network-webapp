$(function() {
			LAYOUT.top_menu.maculamenu({
						url			: base + '/admin/jcwal-network-webapp/menu',
						left_menu	: LAYOUT.side_content,
						left_toggle : LAYOUT.leftToggler						
					});
			$.maculapage();
		});