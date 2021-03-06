/*
 * Copyright 2011 Witoslaw Koczewsi <wi@koczewski.de>, Artjom Kochtchi
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package ilarkesto.di;

import ilarkesto.base.BeanMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Bean provider which uses a bean/object as the source for beans. Each getter in the bean acts as a bean
 * provided by this bean provider.
 * 
 * @author wko
 * @param <T>
 */
public class ReflectionBeanProvider<T> extends ABeanProvider {

	private BeanMap<T> beanMap;

    /**
     *
     * @param bean
     */
    public ReflectionBeanProvider(T bean) {
		beanMap = new BeanMap<>(bean);
	}

    /**
     *
     * @return
     */
    public T getBean() {
		return beanMap.getBean();
	}

        @Override
	public final Set<String> beanNames() {
		Set<String> result = new HashSet<>(beanMap.keySet());
		result.remove("class");
		return result;
	}

    /**
     *
     * @param beanName
     * @return
     */
    public final boolean containsBean(String beanName) {
		return beanMap.containsKey(beanName);
	}

        @Override
	public final Object getBean(String beanName) {
		return beanMap.get(beanName);
	}

        @Override
	public final Class getBeanType(String beanName) {
		return beanMap.getType(beanName);
	}

	@Override
	public String toString() {
		return beanMap.getBean().toString();
		// return "ReflectionBeanProvider: " + Utl.toStringWithType(beanMap.getBean());
	}

}
