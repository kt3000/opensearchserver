/*
 * License Agreement for OpenSearchServer
 * <p/>
 * Copyright (C) 2011-2017 Emmanuel Keller / Jaeksoft
 * <p/>
 * http://www.open-search-server.com
 * <p/>
 * This file is part of OpenSearchServer.
 * <p/>
 * OpenSearchServer is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * OpenSearchServer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with OpenSearchServer.
 * If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaeksoft.searchlib.webservice.crawler.webcrawler;

import com.jaeksoft.searchlib.webservice.CommonListResult;
import com.jaeksoft.searchlib.webservice.CommonResult;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index/{index_name}/crawler/web")
public interface RestWebCrawler {

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/run")
	CommonResult run(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("once") Boolean once);

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/run")
	CommonResult stop(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/run")
	CommonResult status(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/inclusion")
	CommonResult injectPatternsInclusion(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("replace") Boolean replaceAll,
			@QueryParam("inject_urls") Boolean inject_urls, List<String> injectList);

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/inclusion")
	CommonResult deletePatternsInclusion(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, List<String> deleteList);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/hostnames")
	HostnamesResult getHostnames(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("min_count") Integer minCount);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/inclusion")
	CommonListResult<String> extractPatternsInclusion(@PathParam("index_name") String use,
			@QueryParam("login") String login, @QueryParam("key") String key,
			@QueryParam("starts_with") String startsWith);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/exclusion")
	CommonResult injectPatternsExclusion(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("replace") Boolean replaceAll, List<String> injectList);

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/exclusion")
	CommonResult deletePatternsExclusion(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, List<String> deleteList);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/exclusion")
	CommonListResult<String> extractPatternsExclusion(@PathParam("index_name") String use,
			@QueryParam("login") String login, @QueryParam("key") String key,
			@QueryParam("starts_with") String startsWith);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/status")
	CommonResult getPatternStatus(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/patterns/status")
	CommonResult setPatternStatus(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("inclusion") Boolean inclusion,
			@QueryParam("exclusion") Boolean exclusion);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/sitemap")
	CommonResult injectSiteMap(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("site_map_url") List<String> addListSiteMap);

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/sitemap")
	CommonResult deleteSiteMap(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("site_map_url") List<String> deleteList);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/sitemap")
	CommonListResult<String> getSiteMap(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/crawl")
	CommonResult crawl(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("url") String url, @QueryParam("returnData") Boolean returnData);

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/crawl")
	CommonResult crawlPost(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @FormParam("url") String url, @FormParam("returnData") Boolean returnData);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/urls")
	CommonResult injectUrls(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("replace") Boolean replaceAll, List<String> urls);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/urls")
	CommonResult getUrls(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/urls")
	CommonResult truncateUrls(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/robotstxt")
	CommonResult robotstxt(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @QueryParam("enable") Boolean enable);

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/properties")
	CommonResult getProperties(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key);

	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Path("/properties/{property}")
	CommonResult setProperty(@PathParam("index_name") String use, @QueryParam("login") String login,
			@QueryParam("key") String key, @PathParam("property") String property, @QueryParam("value") String value);
}
