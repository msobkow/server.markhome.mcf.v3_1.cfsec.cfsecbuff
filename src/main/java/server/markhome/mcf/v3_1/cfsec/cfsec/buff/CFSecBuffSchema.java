// Description: Java 25 buffer implementation of a CFSec schema.

/*
 *	server.markhome.mcf.CFSec
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFSec - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Mark's Code Fractal CFSec.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.mcf.v3_1.cfsec.cfsec.buff;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFSecBuffSchema
	implements ICFSecSchema
{
	protected static ICFSecTablePerms tablePerms;

	protected ICFSecClusterTable tableCluster;
	protected ICFSecISOCcyTable tableISOCcy;
	protected ICFSecISOCtryTable tableISOCtry;
	protected ICFSecISOCtryCcyTable tableISOCtryCcy;
	protected ICFSecISOCtryLangTable tableISOCtryLang;
	protected ICFSecISOLangTable tableISOLang;
	protected ICFSecISOTZoneTable tableISOTZone;
	protected ICFSecSecClusGrpTable tableSecClusGrp;
	protected ICFSecSecClusGrpIncTable tableSecClusGrpInc;
	protected ICFSecSecClusGrpMembTable tableSecClusGrpMemb;
	protected ICFSecSecClusRoleTable tableSecClusRole;
	protected ICFSecSecClusRoleMembTable tableSecClusRoleMemb;
	protected ICFSecSecRoleTable tableSecRole;
	protected ICFSecSecRoleEnablesTable tableSecRoleEnables;
	protected ICFSecSecRoleMembTable tableSecRoleMemb;
	protected ICFSecSecSessionTable tableSecSession;
	protected ICFSecSecSysGrpTable tableSecSysGrp;
	protected ICFSecSecSysGrpIncTable tableSecSysGrpInc;
	protected ICFSecSecSysGrpMembTable tableSecSysGrpMemb;
	protected ICFSecSecTentGrpTable tableSecTentGrp;
	protected ICFSecSecTentGrpIncTable tableSecTentGrpInc;
	protected ICFSecSecTentGrpMembTable tableSecTentGrpMemb;
	protected ICFSecSecTentRoleTable tableSecTentRole;
	protected ICFSecSecTentRoleMembTable tableSecTentRoleMemb;
	protected ICFSecSecUserTable tableSecUser;
	protected ICFSecSecUserEMConfTable tableSecUserEMConf;
	protected ICFSecSecUserPWHistoryTable tableSecUserPWHistory;
	protected ICFSecSecUserPWResetTable tableSecUserPWReset;
	protected ICFSecSecUserPasswordTable tableSecUserPassword;
	protected ICFSecSysClusterTable tableSysCluster;
	protected ICFSecTenantTable tableTenant;

	protected ICFSecClusterFactory factoryCluster;
	protected ICFSecISOCcyFactory factoryISOCcy;
	protected ICFSecISOCtryFactory factoryISOCtry;
	protected ICFSecISOCtryCcyFactory factoryISOCtryCcy;
	protected ICFSecISOCtryLangFactory factoryISOCtryLang;
	protected ICFSecISOLangFactory factoryISOLang;
	protected ICFSecISOTZoneFactory factoryISOTZone;
	protected ICFSecSecClusGrpFactory factorySecClusGrp;
	protected ICFSecSecClusGrpIncFactory factorySecClusGrpInc;
	protected ICFSecSecClusGrpMembFactory factorySecClusGrpMemb;
	protected ICFSecSecClusRoleFactory factorySecClusRole;
	protected ICFSecSecClusRoleMembFactory factorySecClusRoleMemb;
	protected ICFSecSecRoleFactory factorySecRole;
	protected ICFSecSecRoleEnablesFactory factorySecRoleEnables;
	protected ICFSecSecRoleMembFactory factorySecRoleMemb;
	protected ICFSecSecSessionFactory factorySecSession;
	protected ICFSecSecSysGrpFactory factorySecSysGrp;
	protected ICFSecSecSysGrpIncFactory factorySecSysGrpInc;
	protected ICFSecSecSysGrpMembFactory factorySecSysGrpMemb;
	protected ICFSecSecTentGrpFactory factorySecTentGrp;
	protected ICFSecSecTentGrpIncFactory factorySecTentGrpInc;
	protected ICFSecSecTentGrpMembFactory factorySecTentGrpMemb;
	protected ICFSecSecTentRoleFactory factorySecTentRole;
	protected ICFSecSecTentRoleMembFactory factorySecTentRoleMemb;
	protected ICFSecSecUserFactory factorySecUser;
	protected ICFSecSecUserEMConfFactory factorySecUserEMConf;
	protected ICFSecSecUserPWHistoryFactory factorySecUserPWHistory;
	protected ICFSecSecUserPWResetFactory factorySecUserPWReset;
	protected ICFSecSecUserPasswordFactory factorySecUserPassword;
	protected ICFSecSysClusterFactory factorySysCluster;
	protected ICFSecTenantFactory factoryTenant;

	@Override
	public int initClassMapEntries(int value) {
		return( ICFSecSchema.doInitClassMapEntries(value) );
	}

	@Override
	public void wireRecConstructors() {
		ICFSecSchema.ClassMapEntry entry;
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecCluster ret = new CFSecBuffCluster();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecCluster.CLASS_CODE)[" + ICFSecCluster.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecTenant.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecTenant ret = new CFSecBuffTenant();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecTenant.CLASS_CODE)[" + ICFSecTenant.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCcy ret = new CFSecBuffISOCcy();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCcy.CLASS_CODE)[" + ICFSecISOCcy.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtry.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtry ret = new CFSecBuffISOCtry();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtry.CLASS_CODE)[" + ICFSecISOCtry.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryCcy.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtryCcy ret = new CFSecBuffISOCtryCcy();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryCcy.CLASS_CODE)[" + ICFSecISOCtryCcy.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOCtryLang ret = new CFSecBuffISOCtryLang();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOCtryLang.CLASS_CODE)[" + ICFSecISOCtryLang.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOLang.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOLang ret = new CFSecBuffISOLang();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOLang.CLASS_CODE)[" + ICFSecISOLang.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOTZone.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecISOTZone ret = new CFSecBuffISOTZone();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecISOTZone.CLASS_CODE)[" + ICFSecISOTZone.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUser.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUser ret = new CFSecBuffSecUser();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUser.CLASS_CODE)[" + ICFSecSecUser.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPassword.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUserPassword ret = new CFSecBuffSecUserPassword();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPassword.CLASS_CODE)[" + ICFSecSecUserPassword.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserEMConf.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUserEMConf ret = new CFSecBuffSecUserEMConf();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserEMConf.CLASS_CODE)[" + ICFSecSecUserEMConf.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPWReset.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUserPWReset ret = new CFSecBuffSecUserPWReset();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPWReset.CLASS_CODE)[" + ICFSecSecUserPWReset.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPWHistory.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecUserPWHistory ret = new CFSecBuffSecUserPWHistory();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecUserPWHistory.CLASS_CODE)[" + ICFSecSecUserPWHistory.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecSysGrp ret = new CFSecBuffSecSysGrp();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrp.CLASS_CODE)[" + ICFSecSecSysGrp.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecSysGrpInc ret = new CFSecBuffSecSysGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrpInc.CLASS_CODE)[" + ICFSecSecSysGrpInc.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecSysGrpMemb ret = new CFSecBuffSecSysGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSysGrpMemb.CLASS_CODE)[" + ICFSecSecSysGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecClusGrp ret = new CFSecBuffSecClusGrp();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrp.CLASS_CODE)[" + ICFSecSecClusGrp.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecClusGrpInc ret = new CFSecBuffSecClusGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrpInc.CLASS_CODE)[" + ICFSecSecClusGrpInc.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecClusGrpMemb ret = new CFSecBuffSecClusGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusGrpMemb.CLASS_CODE)[" + ICFSecSecClusGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrp.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecTentGrp ret = new CFSecBuffSecTentGrp();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrp.CLASS_CODE)[" + ICFSecSecTentGrp.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrpInc.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecTentGrpInc ret = new CFSecBuffSecTentGrpInc();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrpInc.CLASS_CODE)[" + ICFSecSecTentGrpInc.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrpMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecTentGrpMemb ret = new CFSecBuffSecTentGrpMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentGrpMemb.CLASS_CODE)[" + ICFSecSecTentGrpMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecRole ret = new CFSecBuffSecRole();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRole.CLASS_CODE)[" + ICFSecSecRole.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRoleEnables.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecRoleEnables ret = new CFSecBuffSecRoleEnables();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRoleEnables.CLASS_CODE)[" + ICFSecSecRoleEnables.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecRoleMemb ret = new CFSecBuffSecRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecRoleMemb.CLASS_CODE)[" + ICFSecSecRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecClusRole ret = new CFSecBuffSecClusRole();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusRole.CLASS_CODE)[" + ICFSecSecClusRole.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecClusRoleMemb ret = new CFSecBuffSecClusRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecClusRoleMemb.CLASS_CODE)[" + ICFSecSecClusRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentRole.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecTentRole ret = new CFSecBuffSecTentRole();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentRole.CLASS_CODE)[" + ICFSecSecTentRole.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentRoleMemb.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecTentRoleMemb ret = new CFSecBuffSecTentRoleMemb();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecTentRoleMemb.CLASS_CODE)[" + ICFSecSecTentRoleMemb.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSession.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSecSession ret = new CFSecBuffSecSession();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSecSession.CLASS_CODE)[" + ICFSecSecSession.CLASS_CODE + "]");
		}
	
		entry = ICFSecSchema.getClassMapByBackingClassCode(ICFSecSysCluster.CLASS_CODE);
		if (entry != null) {
			entry.setBackingRecConstructor( new BackingRecConstructor() {
				@Override
				public Object instantiate() {
					ICFSecSysCluster ret = new CFSecBuffSysCluster();
					return(ret);
				}
			});
		}
		else {
			throw new CFLibNullArgumentException(CFSecBuffSchema.class, "wireRecConstructors", 0, "ICFSecSchema.getClassMapByBackingClassCode(ICFSecSysCluster.CLASS_CODE)[" + ICFSecSysCluster.CLASS_CODE + "]");
		}
	
	}

	@Override
	public void wireTableTableInstances() {
		throw new CFLibMustOverrideException(getClass(), "wireTableTableInstances");
	}

	@Override		
	public ICFSecSchema getCFSecSchema() {
		return( ICFSecSchema.getBackingCFSec() );
	}

	@Override
	public void setCFSecSchema(ICFSecSchema schema) {
		ICFSecSchema.setBackingCFSec(schema);
		schema.wireRecConstructors();
	}

	public CFSecBuffSchema() {

	tableCluster = null; // new CFSecBuffClusterTable();
	tableISOCcy = null; // new CFSecBuffISOCcyTable();
	tableISOCtry = null; // new CFSecBuffISOCtryTable();
	tableISOCtryCcy = null; // new CFSecBuffISOCtryCcyTable();
	tableISOCtryLang = null; // new CFSecBuffISOCtryLangTable();
	tableISOLang = null; // new CFSecBuffISOLangTable();
	tableISOTZone = null; // new CFSecBuffISOTZoneTable();
	tableSecClusGrp = null; // new CFSecBuffSecClusGrpTable();
	tableSecClusGrpInc = null; // new CFSecBuffSecClusGrpIncTable();
	tableSecClusGrpMemb = null; // new CFSecBuffSecClusGrpMembTable();
	tableSecClusRole = null; // new CFSecBuffSecClusRoleTable();
	tableSecClusRoleMemb = null; // new CFSecBuffSecClusRoleMembTable();
	tableSecRole = null; // new CFSecBuffSecRoleTable();
	tableSecRoleEnables = null; // new CFSecBuffSecRoleEnablesTable();
	tableSecRoleMemb = null; // new CFSecBuffSecRoleMembTable();
	tableSecSession = null; // new CFSecBuffSecSessionTable();
	tableSecSysGrp = null; // new CFSecBuffSecSysGrpTable();
	tableSecSysGrpInc = null; // new CFSecBuffSecSysGrpIncTable();
	tableSecSysGrpMemb = null; // new CFSecBuffSecSysGrpMembTable();
	tableSecTentGrp = null; // new CFSecBuffSecTentGrpTable();
	tableSecTentGrpInc = null; // new CFSecBuffSecTentGrpIncTable();
	tableSecTentGrpMemb = null; // new CFSecBuffSecTentGrpMembTable();
	tableSecTentRole = null; // new CFSecBuffSecTentRoleTable();
	tableSecTentRoleMemb = null; // new CFSecBuffSecTentRoleMembTable();
	tableSecUser = null; // new CFSecBuffSecUserTable();
	tableSecUserEMConf = null; // new CFSecBuffSecUserEMConfTable();
	tableSecUserPWHistory = null; // new CFSecBuffSecUserPWHistoryTable();
	tableSecUserPWReset = null; // new CFSecBuffSecUserPWResetTable();
	tableSecUserPassword = null; // new CFSecBuffSecUserPasswordTable();
	tableSysCluster = null; // new CFSecBuffSysClusterTable();
	tableTenant = null; // new CFSecBuffTenantTable();

	factoryCluster = new CFSecBuffClusterDefaultFactory();
	factoryISOCcy = new CFSecBuffISOCcyDefaultFactory();
	factoryISOCtry = new CFSecBuffISOCtryDefaultFactory();
	factoryISOCtryCcy = new CFSecBuffISOCtryCcyDefaultFactory();
	factoryISOCtryLang = new CFSecBuffISOCtryLangDefaultFactory();
	factoryISOLang = new CFSecBuffISOLangDefaultFactory();
	factoryISOTZone = new CFSecBuffISOTZoneDefaultFactory();
	factorySecClusGrp = new CFSecBuffSecClusGrpDefaultFactory();
	factorySecClusGrpInc = new CFSecBuffSecClusGrpIncDefaultFactory();
	factorySecClusGrpMemb = new CFSecBuffSecClusGrpMembDefaultFactory();
	factorySecClusRole = new CFSecBuffSecClusRoleDefaultFactory();
	factorySecClusRoleMemb = new CFSecBuffSecClusRoleMembDefaultFactory();
	factorySecRole = new CFSecBuffSecRoleDefaultFactory();
	factorySecRoleEnables = new CFSecBuffSecRoleEnablesDefaultFactory();
	factorySecRoleMemb = new CFSecBuffSecRoleMembDefaultFactory();
	factorySecSession = new CFSecBuffSecSessionDefaultFactory();
	factorySecSysGrp = new CFSecBuffSecSysGrpDefaultFactory();
	factorySecSysGrpInc = new CFSecBuffSecSysGrpIncDefaultFactory();
	factorySecSysGrpMemb = new CFSecBuffSecSysGrpMembDefaultFactory();
	factorySecTentGrp = new CFSecBuffSecTentGrpDefaultFactory();
	factorySecTentGrpInc = new CFSecBuffSecTentGrpIncDefaultFactory();
	factorySecTentGrpMemb = new CFSecBuffSecTentGrpMembDefaultFactory();
	factorySecTentRole = new CFSecBuffSecTentRoleDefaultFactory();
	factorySecTentRoleMemb = new CFSecBuffSecTentRoleMembDefaultFactory();
	factorySecUser = new CFSecBuffSecUserDefaultFactory();
	factorySecUserEMConf = new CFSecBuffSecUserEMConfDefaultFactory();
	factorySecUserPWHistory = new CFSecBuffSecUserPWHistoryDefaultFactory();
	factorySecUserPWReset = new CFSecBuffSecUserPWResetDefaultFactory();
	factorySecUserPassword = new CFSecBuffSecUserPasswordDefaultFactory();
	factorySysCluster = new CFSecBuffSysClusterDefaultFactory();
	factoryTenant = new CFSecBuffTenantDefaultFactory();	}

	public ICFSecSchema newSchema() {
		throw new CFLibMustOverrideException( getClass(), "newSchema" );
	}

	/**
	 *	Get the next ISOCcyIdGen identifier.
	 *
	 *	@return	The next ISOCcyIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCcyIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCcyIdGen");
	}

	/**
	 *	Get the next ISOCtryIdGen identifier.
	 *
	 *	@return	The next ISOCtryIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOCtryIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOCtryIdGen");
	}

	/**
	 *	Get the next ISOLangIdGen identifier.
	 *
	 *	@return	The next ISOLangIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOLangIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOLangIdGen");
	}

	/**
	 *	Get the next ISOTZoneIdGen identifier.
	 *
	 *	@return	The next ISOTZoneIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public short nextISOTZoneIdGen() {
		throw new CFLibMustOverrideException(getClass(), "nextISOTZoneIdGen");
	}

	/**
	 *	Get the next ClusterIdGen identifier.
	 *
	 *	@return	The next ClusterIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextClusterIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSessionIdGen identifier.
	 *
	 *	@return	The next SecSessionIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSessionIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecUserIdGen identifier.
	 *
	 *	@return	The next SecUserIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecUserIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next TenantIdGen identifier.
	 *
	 *	@return	The next TenantIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextTenantIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecSysGrpIdGen identifier.
	 *
	 *	@return	The next SecSysGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecSysGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusGrpIdGen identifier.
	 *
	 *	@return	The next SecClusGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecClusRoleIdGen identifier.
	 *
	 *	@return	The next SecClusRoleIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecClusRoleIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentGrpIdGen identifier.
	 *
	 *	@return	The next SecTentGrpIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentGrpIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	/**
	 *	Get the next SecTentRoleIdGen identifier.
	 *
	 *	@return	The next SecTentRoleIdGen identifier.
	 *
	 *	@throws CFLibNotSupportedException thrown by client-side implementations.
	 */
	public CFLibDbKeyHash256 nextSecTentRoleIdGen() {
		return( new CFLibDbKeyHash256(0) );
	}

	public ICFSecClusterTable getTableCluster() {
		return( tableCluster );
	}

	public void setTableCluster( ICFSecClusterTable value ) {
		tableCluster = value;
	}

	public ICFSecClusterFactory getFactoryCluster() {
		return( factoryCluster );
	}

	public void setFactoryCluster( ICFSecClusterFactory value ) {
		factoryCluster = value;
	}

	public ICFSecISOCcyTable getTableISOCcy() {
		return( tableISOCcy );
	}

	public void setTableISOCcy( ICFSecISOCcyTable value ) {
		tableISOCcy = value;
	}

	public ICFSecISOCcyFactory getFactoryISOCcy() {
		return( factoryISOCcy );
	}

	public void setFactoryISOCcy( ICFSecISOCcyFactory value ) {
		factoryISOCcy = value;
	}

	public ICFSecISOCtryTable getTableISOCtry() {
		return( tableISOCtry );
	}

	public void setTableISOCtry( ICFSecISOCtryTable value ) {
		tableISOCtry = value;
	}

	public ICFSecISOCtryFactory getFactoryISOCtry() {
		return( factoryISOCtry );
	}

	public void setFactoryISOCtry( ICFSecISOCtryFactory value ) {
		factoryISOCtry = value;
	}

	public ICFSecISOCtryCcyTable getTableISOCtryCcy() {
		return( tableISOCtryCcy );
	}

	public void setTableISOCtryCcy( ICFSecISOCtryCcyTable value ) {
		tableISOCtryCcy = value;
	}

	public ICFSecISOCtryCcyFactory getFactoryISOCtryCcy() {
		return( factoryISOCtryCcy );
	}

	public void setFactoryISOCtryCcy( ICFSecISOCtryCcyFactory value ) {
		factoryISOCtryCcy = value;
	}

	public ICFSecISOCtryLangTable getTableISOCtryLang() {
		return( tableISOCtryLang );
	}

	public void setTableISOCtryLang( ICFSecISOCtryLangTable value ) {
		tableISOCtryLang = value;
	}

	public ICFSecISOCtryLangFactory getFactoryISOCtryLang() {
		return( factoryISOCtryLang );
	}

	public void setFactoryISOCtryLang( ICFSecISOCtryLangFactory value ) {
		factoryISOCtryLang = value;
	}

	public ICFSecISOLangTable getTableISOLang() {
		return( tableISOLang );
	}

	public void setTableISOLang( ICFSecISOLangTable value ) {
		tableISOLang = value;
	}

	public ICFSecISOLangFactory getFactoryISOLang() {
		return( factoryISOLang );
	}

	public void setFactoryISOLang( ICFSecISOLangFactory value ) {
		factoryISOLang = value;
	}

	public ICFSecISOTZoneTable getTableISOTZone() {
		return( tableISOTZone );
	}

	public void setTableISOTZone( ICFSecISOTZoneTable value ) {
		tableISOTZone = value;
	}

	public ICFSecISOTZoneFactory getFactoryISOTZone() {
		return( factoryISOTZone );
	}

	public void setFactoryISOTZone( ICFSecISOTZoneFactory value ) {
		factoryISOTZone = value;
	}

	public ICFSecSecClusGrpTable getTableSecClusGrp() {
		return( tableSecClusGrp );
	}

	public void setTableSecClusGrp( ICFSecSecClusGrpTable value ) {
		tableSecClusGrp = value;
	}

	public ICFSecSecClusGrpFactory getFactorySecClusGrp() {
		return( factorySecClusGrp );
	}

	public void setFactorySecClusGrp( ICFSecSecClusGrpFactory value ) {
		factorySecClusGrp = value;
	}

	public ICFSecSecClusGrpIncTable getTableSecClusGrpInc() {
		return( tableSecClusGrpInc );
	}

	public void setTableSecClusGrpInc( ICFSecSecClusGrpIncTable value ) {
		tableSecClusGrpInc = value;
	}

	public ICFSecSecClusGrpIncFactory getFactorySecClusGrpInc() {
		return( factorySecClusGrpInc );
	}

	public void setFactorySecClusGrpInc( ICFSecSecClusGrpIncFactory value ) {
		factorySecClusGrpInc = value;
	}

	public ICFSecSecClusGrpMembTable getTableSecClusGrpMemb() {
		return( tableSecClusGrpMemb );
	}

	public void setTableSecClusGrpMemb( ICFSecSecClusGrpMembTable value ) {
		tableSecClusGrpMemb = value;
	}

	public ICFSecSecClusGrpMembFactory getFactorySecClusGrpMemb() {
		return( factorySecClusGrpMemb );
	}

	public void setFactorySecClusGrpMemb( ICFSecSecClusGrpMembFactory value ) {
		factorySecClusGrpMemb = value;
	}

	public ICFSecSecClusRoleTable getTableSecClusRole() {
		return( tableSecClusRole );
	}

	public void setTableSecClusRole( ICFSecSecClusRoleTable value ) {
		tableSecClusRole = value;
	}

	public ICFSecSecClusRoleFactory getFactorySecClusRole() {
		return( factorySecClusRole );
	}

	public void setFactorySecClusRole( ICFSecSecClusRoleFactory value ) {
		factorySecClusRole = value;
	}

	public ICFSecSecClusRoleMembTable getTableSecClusRoleMemb() {
		return( tableSecClusRoleMemb );
	}

	public void setTableSecClusRoleMemb( ICFSecSecClusRoleMembTable value ) {
		tableSecClusRoleMemb = value;
	}

	public ICFSecSecClusRoleMembFactory getFactorySecClusRoleMemb() {
		return( factorySecClusRoleMemb );
	}

	public void setFactorySecClusRoleMemb( ICFSecSecClusRoleMembFactory value ) {
		factorySecClusRoleMemb = value;
	}

	public ICFSecSecRoleTable getTableSecRole() {
		return( tableSecRole );
	}

	public void setTableSecRole( ICFSecSecRoleTable value ) {
		tableSecRole = value;
	}

	public ICFSecSecRoleFactory getFactorySecRole() {
		return( factorySecRole );
	}

	public void setFactorySecRole( ICFSecSecRoleFactory value ) {
		factorySecRole = value;
	}

	public ICFSecSecRoleEnablesTable getTableSecRoleEnables() {
		return( tableSecRoleEnables );
	}

	public void setTableSecRoleEnables( ICFSecSecRoleEnablesTable value ) {
		tableSecRoleEnables = value;
	}

	public ICFSecSecRoleEnablesFactory getFactorySecRoleEnables() {
		return( factorySecRoleEnables );
	}

	public void setFactorySecRoleEnables( ICFSecSecRoleEnablesFactory value ) {
		factorySecRoleEnables = value;
	}

	public ICFSecSecRoleMembTable getTableSecRoleMemb() {
		return( tableSecRoleMemb );
	}

	public void setTableSecRoleMemb( ICFSecSecRoleMembTable value ) {
		tableSecRoleMemb = value;
	}

	public ICFSecSecRoleMembFactory getFactorySecRoleMemb() {
		return( factorySecRoleMemb );
	}

	public void setFactorySecRoleMemb( ICFSecSecRoleMembFactory value ) {
		factorySecRoleMemb = value;
	}

	public ICFSecSecSessionTable getTableSecSession() {
		return( tableSecSession );
	}

	public void setTableSecSession( ICFSecSecSessionTable value ) {
		tableSecSession = value;
	}

	public ICFSecSecSessionFactory getFactorySecSession() {
		return( factorySecSession );
	}

	public void setFactorySecSession( ICFSecSecSessionFactory value ) {
		factorySecSession = value;
	}

	public ICFSecSecSysGrpTable getTableSecSysGrp() {
		return( tableSecSysGrp );
	}

	public void setTableSecSysGrp( ICFSecSecSysGrpTable value ) {
		tableSecSysGrp = value;
	}

	public ICFSecSecSysGrpFactory getFactorySecSysGrp() {
		return( factorySecSysGrp );
	}

	public void setFactorySecSysGrp( ICFSecSecSysGrpFactory value ) {
		factorySecSysGrp = value;
	}

	public ICFSecSecSysGrpIncTable getTableSecSysGrpInc() {
		return( tableSecSysGrpInc );
	}

	public void setTableSecSysGrpInc( ICFSecSecSysGrpIncTable value ) {
		tableSecSysGrpInc = value;
	}

	public ICFSecSecSysGrpIncFactory getFactorySecSysGrpInc() {
		return( factorySecSysGrpInc );
	}

	public void setFactorySecSysGrpInc( ICFSecSecSysGrpIncFactory value ) {
		factorySecSysGrpInc = value;
	}

	public ICFSecSecSysGrpMembTable getTableSecSysGrpMemb() {
		return( tableSecSysGrpMemb );
	}

	public void setTableSecSysGrpMemb( ICFSecSecSysGrpMembTable value ) {
		tableSecSysGrpMemb = value;
	}

	public ICFSecSecSysGrpMembFactory getFactorySecSysGrpMemb() {
		return( factorySecSysGrpMemb );
	}

	public void setFactorySecSysGrpMemb( ICFSecSecSysGrpMembFactory value ) {
		factorySecSysGrpMemb = value;
	}

	public ICFSecSecTentGrpTable getTableSecTentGrp() {
		return( tableSecTentGrp );
	}

	public void setTableSecTentGrp( ICFSecSecTentGrpTable value ) {
		tableSecTentGrp = value;
	}

	public ICFSecSecTentGrpFactory getFactorySecTentGrp() {
		return( factorySecTentGrp );
	}

	public void setFactorySecTentGrp( ICFSecSecTentGrpFactory value ) {
		factorySecTentGrp = value;
	}

	public ICFSecSecTentGrpIncTable getTableSecTentGrpInc() {
		return( tableSecTentGrpInc );
	}

	public void setTableSecTentGrpInc( ICFSecSecTentGrpIncTable value ) {
		tableSecTentGrpInc = value;
	}

	public ICFSecSecTentGrpIncFactory getFactorySecTentGrpInc() {
		return( factorySecTentGrpInc );
	}

	public void setFactorySecTentGrpInc( ICFSecSecTentGrpIncFactory value ) {
		factorySecTentGrpInc = value;
	}

	public ICFSecSecTentGrpMembTable getTableSecTentGrpMemb() {
		return( tableSecTentGrpMemb );
	}

	public void setTableSecTentGrpMemb( ICFSecSecTentGrpMembTable value ) {
		tableSecTentGrpMemb = value;
	}

	public ICFSecSecTentGrpMembFactory getFactorySecTentGrpMemb() {
		return( factorySecTentGrpMemb );
	}

	public void setFactorySecTentGrpMemb( ICFSecSecTentGrpMembFactory value ) {
		factorySecTentGrpMemb = value;
	}

	public ICFSecSecTentRoleTable getTableSecTentRole() {
		return( tableSecTentRole );
	}

	public void setTableSecTentRole( ICFSecSecTentRoleTable value ) {
		tableSecTentRole = value;
	}

	public ICFSecSecTentRoleFactory getFactorySecTentRole() {
		return( factorySecTentRole );
	}

	public void setFactorySecTentRole( ICFSecSecTentRoleFactory value ) {
		factorySecTentRole = value;
	}

	public ICFSecSecTentRoleMembTable getTableSecTentRoleMemb() {
		return( tableSecTentRoleMemb );
	}

	public void setTableSecTentRoleMemb( ICFSecSecTentRoleMembTable value ) {
		tableSecTentRoleMemb = value;
	}

	public ICFSecSecTentRoleMembFactory getFactorySecTentRoleMemb() {
		return( factorySecTentRoleMemb );
	}

	public void setFactorySecTentRoleMemb( ICFSecSecTentRoleMembFactory value ) {
		factorySecTentRoleMemb = value;
	}

	public ICFSecSecUserTable getTableSecUser() {
		return( tableSecUser );
	}

	public void setTableSecUser( ICFSecSecUserTable value ) {
		tableSecUser = value;
	}

	public ICFSecSecUserFactory getFactorySecUser() {
		return( factorySecUser );
	}

	public void setFactorySecUser( ICFSecSecUserFactory value ) {
		factorySecUser = value;
	}

	public ICFSecSecUserEMConfTable getTableSecUserEMConf() {
		return( tableSecUserEMConf );
	}

	public void setTableSecUserEMConf( ICFSecSecUserEMConfTable value ) {
		tableSecUserEMConf = value;
	}

	public ICFSecSecUserEMConfFactory getFactorySecUserEMConf() {
		return( factorySecUserEMConf );
	}

	public void setFactorySecUserEMConf( ICFSecSecUserEMConfFactory value ) {
		factorySecUserEMConf = value;
	}

	public ICFSecSecUserPWHistoryTable getTableSecUserPWHistory() {
		return( tableSecUserPWHistory );
	}

	public void setTableSecUserPWHistory( ICFSecSecUserPWHistoryTable value ) {
		tableSecUserPWHistory = value;
	}

	public ICFSecSecUserPWHistoryFactory getFactorySecUserPWHistory() {
		return( factorySecUserPWHistory );
	}

	public void setFactorySecUserPWHistory( ICFSecSecUserPWHistoryFactory value ) {
		factorySecUserPWHistory = value;
	}

	public ICFSecSecUserPWResetTable getTableSecUserPWReset() {
		return( tableSecUserPWReset );
	}

	public void setTableSecUserPWReset( ICFSecSecUserPWResetTable value ) {
		tableSecUserPWReset = value;
	}

	public ICFSecSecUserPWResetFactory getFactorySecUserPWReset() {
		return( factorySecUserPWReset );
	}

	public void setFactorySecUserPWReset( ICFSecSecUserPWResetFactory value ) {
		factorySecUserPWReset = value;
	}

	public ICFSecSecUserPasswordTable getTableSecUserPassword() {
		return( tableSecUserPassword );
	}

	public void setTableSecUserPassword( ICFSecSecUserPasswordTable value ) {
		tableSecUserPassword = value;
	}

	public ICFSecSecUserPasswordFactory getFactorySecUserPassword() {
		return( factorySecUserPassword );
	}

	public void setFactorySecUserPassword( ICFSecSecUserPasswordFactory value ) {
		factorySecUserPassword = value;
	}

	public ICFSecSysClusterTable getTableSysCluster() {
		return( tableSysCluster );
	}

	public void setTableSysCluster( ICFSecSysClusterTable value ) {
		tableSysCluster = value;
	}

	public ICFSecSysClusterFactory getFactorySysCluster() {
		return( factorySysCluster );
	}

	public void setFactorySysCluster( ICFSecSysClusterFactory value ) {
		factorySysCluster = value;
	}

	public ICFSecTenantTable getTableTenant() {
		return( tableTenant );
	}

	public void setTableTenant( ICFSecTenantTable value ) {
		tableTenant = value;
	}

	public ICFSecTenantFactory getFactoryTenant() {
		return( factoryTenant );
	}

	public void setFactoryTenant( ICFSecTenantFactory value ) {
		factoryTenant = value;
	}

	public static String xmlEncodeString( String val ) {
		StringBuffer buff = new StringBuffer();
		int len = val.length();
		for( int idx = 0; idx < len; idx ++ ) {
			char c = val.charAt( idx );
			switch( c ) {
				case '&':
					buff.append( "&amp;" );
					break;
				case '<':
					buff.append( "&lt;" );
					break;
				case '>':
					buff.append( "&gt;" );
					break;
				case '"':
					buff.append( "&quot;" );
					break;
				case '\'':
					buff.append( "&apos;" );
					break;
				default:
					buff.append( c );
					break;
			}
		}
		return( buff.toString() );
	}

	public void bootstrapSchema(CFSecTableInfo tableInfo[]) {
	}
	
	public void bootstrapAllTablesSecurity(CFLibDbKeyHash256 clusterId, CFLibDbKeyHash256 tenantId, CFSecTableInfo tableInfo[]) {
	}
}
