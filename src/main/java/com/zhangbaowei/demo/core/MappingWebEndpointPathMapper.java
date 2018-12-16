package com.zhangbaowei.demo.core;

import org.springframework.boot.actuate.endpoint.EndpointId;
import org.springframework.boot.actuate.endpoint.web.PathMapper;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

class MyMappingWebEndpointPathMapper implements PathMapper {

	private final Map<EndpointId, String> pathMapping;

	MyMappingWebEndpointPathMapper(Map<String, String> pathMapping) {
		this.pathMapping = new HashMap<>();
		pathMapping.forEach((id, path) -> this.pathMapping
				.put(EndpointId.fromPropertyValue(id), path));
	}

	@Override
	@Deprecated
	public String getRootPath(String endpointId) {
		return getRootPath(EndpointId.of(endpointId));
	}

	@Override
	public String getRootPath(EndpointId endpointId) {
		String path = this.pathMapping.get(endpointId);
		return StringUtils.hasText(path) ? path
				: PathMapper.useEndpointId().getRootPath(endpointId);
	}

}