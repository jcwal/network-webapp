package org.jcwal.so.network.controller;

import javax.validation.Valid;

import org.jcwal.so.network.domain.NetworkResource;
import org.jcwal.so.network.repository.NetworkResourceRepository;
import org.macula.base.security.util.SecurityUtils;
import org.macula.core.exception.FormBindException;
import org.macula.core.mvc.annotation.FormBean;
import org.macula.core.mvc.annotation.OpenApi;
import org.macula.plugins.mda.finder.vo.FinderSelection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

@Controller
public class NetworkResourceManagerController extends AdminNetworkController {

	@Autowired
	private NetworkResourceRepository networkResourceRepository;

	@RequestMapping(value = "/networkresource/list", method = RequestMethod.GET)
	public View index() {
		// return new FinderView(HospitalSchemaRegistory.DOCTOR_SCHEMA);
		return null;
	}

	@RequestMapping(value = "/networkresource/segment", method = RequestMethod.GET)
	public String create(Model model) {
		return super.getRelativePath("/networkresource/segment");
	}

	@RequestMapping(value = "/network/savesagement", method = RequestMethod.POST)
	@OpenApi
	public Long save(@RequestParam(value = "segment", required = true) String sagement,
			@RequestParam(value = "type", required = true) String type) {

		if (hasErrors()) {
			throw new FormBindException(getMergedBindingResults());
		}

		return 0L;
	}

	@RequestMapping(value = "/networkresource/delete", method = RequestMethod.POST)
	@OpenApi
	public boolean delete(@FormBean("selection") FinderSelection selection) {
		for (String itemId : selection.getIterable(SecurityUtils.getUserContext(), true)) {
			if (itemId != null) {
				networkResourceRepository.delete(Long.parseLong(itemId));
			}
		}
		return true;
	}

	@RequestMapping(value = "/network/edit", method = RequestMethod.POST)
	public String edit(@FormBean("selection") FinderSelection selection, Model model) {
		String networkId = selection.getItems().get(0);
		model.addAttribute("networkId", networkId);
		return super.getRelativePath("/network/edit");
	}

	@RequestMapping(value = "/network/save", method = RequestMethod.POST)
	@OpenApi
	public Long save(@FormBean("network") @Valid NetworkResource network) {
		if (hasErrors()) {
			throw new FormBindException(getMergedBindingResults());
		}
		networkResourceRepository.save(network);
		return network.getId();
	}

	@RequestMapping(value = "/network/get/{networkId}", method = RequestMethod.GET)
	@OpenApi
	public NetworkResource getUserInfo(@PathVariable("networkId") Long networkId) {
		return networkResourceRepository.findOne(networkId);
	}
}
