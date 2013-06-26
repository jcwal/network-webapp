package org.jcwal.so.network.controller;

import javax.validation.Valid;

import org.jcwal.so.network.domain.SegmentResource;
import org.jcwal.so.network.repository.SegmentResourceRepository;
import org.jcwal.so.network.service.NetworkResourceService;
import org.jcwal.so.network.service.impl.NetworkSchemaRegistory;
import org.macula.base.security.util.SecurityUtils;
import org.macula.core.exception.FormBindException;
import org.macula.core.mvc.annotation.FormBean;
import org.macula.core.mvc.annotation.OpenApi;
import org.macula.plugins.mda.finder.view.FinderView;
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
public class SegmentResourceManagerController extends AdminNetworkController {

	@Autowired
	private SegmentResourceRepository segmentResourceRepository;

	@Autowired
	private NetworkResourceService networkResourceService;

	@RequestMapping(value = "/segmentresource/list", method = RequestMethod.GET)
	public View index() {
		return new FinderView(NetworkSchemaRegistory.SEGMENTRESOURCE_SCHEMA);
	}

	@RequestMapping(value = "/segmentresource/segment", method = RequestMethod.POST)
	public String segment(@FormBean("selection") FinderSelection selection, Model model) {
		String segmentId = selection.getItems().get(0);
		SegmentResource segmentResource = segmentResourceRepository.findOne(Long.parseLong(segmentId));
		model.addAttribute("segment", segmentResource);
		return super.getRelativePath("/segmentresource/segment");
	}

	@RequestMapping(value = "/segmentresource/batchsegment", method = RequestMethod.POST)
	@OpenApi
	public int batchSegment(@RequestParam(value = "segmentId", required = true) Long segmentId,
			@RequestParam(value = "type", required = true) String type) {
		if (hasErrors()) {
			throw new FormBindException(getMergedBindingResults());
		}
		return networkResourceService.createResourceBySegment(segmentId, type).size();
	}

	@RequestMapping(value = "/segmentresource/delete", method = RequestMethod.POST)
	@OpenApi
	public boolean delete(@FormBean("selection") FinderSelection selection) {
		for (String itemId : selection.getIterable(SecurityUtils.getUserContext(), true)) {
			if (itemId != null) {
				segmentResourceRepository.delete(Long.parseLong(itemId));
			}
		}
		return true;
	}

	@RequestMapping(value = "/segmentresource/create", method = RequestMethod.POST)
	public String create(Model model) {
		return super.getRelativePath("/segmentresource/edit");
	}

	@RequestMapping(value = "/segmentresource/edit", method = RequestMethod.POST)
	public String edit(@FormBean("selection") FinderSelection selection, Model model) {
		String segmentId = selection.getItems().get(0);
		model.addAttribute("segmentId", segmentId);
		return super.getRelativePath("/segmentresource/edit");
	}

	@RequestMapping(value = "/segmentresource/save", method = RequestMethod.POST)
	@OpenApi
	public Long save(@FormBean("segment") @Valid SegmentResource segment) {
		if (hasErrors()) {
			throw new FormBindException(getMergedBindingResults());
		}
		segmentResourceRepository.save(segment);
		return segment.getId();
	}

	//	@RequestMapping(value = "/segmentresource/export", method = RequestMethod.POST)
	//	public ModelAndView export(@FormBean("selection") FinderSelection selection, Model model) {
	//		List<SegmentResource> resources = new ArrayList<SegmentResource>();
	//		List<Long> ids = new ArrayList<Long>();
	//		for (String itemId : selection.getIterable(SecurityUtils.getUserContext(), false)) {
	//			if (itemId != null) {
	//				ids.add(Long.parseLong(itemId));
	//				if (ids.size() > 900) {
	//					resources.addAll(segmentResourceRepository.findIds(ids));
	//					ids.clear();
	//				}
	//			}
	//		}
	//		if (!ids.isEmpty()) {
	//			resources.addAll(segmentResourceRepository.findIds(ids));
	//		}
	//		model.addAttribute("ips", resources);
	//		return new ModelAndView(new ExcelView(getRelativePath("/segmentresource/IPExport")), model.asMap());
	//	}

	@RequestMapping(value = "/segmentresource/get/{segmentId}", method = RequestMethod.GET)
	@OpenApi
	public SegmentResource getSegmentResource(@PathVariable("segmentId") Long segmentId) {
		return segmentResourceRepository.findOne(segmentId);
	}

}
