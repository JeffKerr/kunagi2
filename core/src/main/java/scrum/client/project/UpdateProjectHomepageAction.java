/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package scrum.client.project;

import generated.client.project.UpdateProjectHomepageServiceCall;
import generated.client.project.GUpdateProjectHomepageAction;
import ilarkesto.core.base.Str;
import scrum.client.common.TooltipBuilder;

public class UpdateProjectHomepageAction extends GUpdateProjectHomepageAction {

	public UpdateProjectHomepageAction(scrum.client.project.Project project) {
		super(project);
	}

	@Override
	protected void updateTooltip(TooltipBuilder tb) {
		tb.setText("Export project data, thereby updating the public homepage for this project.");
		if (!project.isScrumTeamMember(getCurrentUser())) tb.addRemark(TooltipBuilder.NOT_SCRUMTEAM);
	}

	@Override
	public boolean isExecutable() {
		if (Str.isBlank(project.getHomepageDir())) return false;
		return true;
	}

	@Override
	public boolean isPermitted() {
		if (!project.isScrumTeamMember(getCurrentUser())) return false;
		return true;
	}

	@Override
	public String getLabel() {
		return "Update homepage";
	}

	@Override
	protected void onExecute() {
		new UpdateProjectHomepageServiceCall().execute();
	}

}