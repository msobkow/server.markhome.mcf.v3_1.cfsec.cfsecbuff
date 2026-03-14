// Description: Java 25 implementation of a TSecGrpMemb buffer

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
import java.io.*;
import java.math.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

public class CFSecBuffTSecGrpMemb
	implements ICFSecTSecGrpMemb, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredTSecGrpMembId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecTSecGrpMemb.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecTSecGrpMemb.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 requiredTenantId;
	protected CFLibDbKeyHash256 requiredTSecGroupId;
	protected CFLibDbKeyHash256 requiredSecUserId;

	public CFSecBuffTSecGrpMemb() {
		requiredTSecGrpMembId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpMemb.TSECGRPMEMBID_INIT_VALUE.toString() );
		requiredTenantId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpMemb.TENANTID_INIT_VALUE.toString() );
		requiredTSecGroupId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpMemb.TSECGROUPID_INIT_VALUE.toString() );
		requiredSecUserId = CFLibDbKeyHash256.fromHex( ICFSecTSecGrpMemb.SECUSERID_INIT_VALUE.toString() );
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredTSecGrpMembId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredTSecGrpMembId) {
		if (requiredTSecGrpMembId != null) {
			setRequiredTSecGrpMembId(requiredTSecGrpMembId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTSecGrpMembId() {
		return( requiredTSecGrpMembId );
	}

	@Override
	public void setRequiredTSecGrpMembId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredTSecGrpMembId",
				1,
				"value" );
		}
		requiredTSecGrpMembId = value;
	}

	@Override
	public CFLibDbKeyHash256 getCreatedByUserId() {
		return( createdByUserId );
	}

	@Override
	public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
		createdByUserId = value;
	}

	@Override
	public LocalDateTime getCreatedAt() {
		return( createdAt );
	}

	@Override
	public void setCreatedAt( LocalDateTime value ) {
		createdAt = value;
	}

	@Override
	public CFLibDbKeyHash256 getUpdatedByUserId() {
		return( updatedByUserId );
	}

	@Override
	public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
		updatedByUserId = value;
	}

	@Override
	public LocalDateTime getUpdatedAt() {
		return( updatedAt );
	}

	@Override
	public void setUpdatedAt( LocalDateTime value ) {
		updatedAt = value;
	}
	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public int getClassCode() {
		return( ICFSecTSecGrpMemb.CLASS_CODE );
	}

	@Override
	public ICFSecTenant getRequiredOwnerTenant() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredOwnerTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecTenant targetRec = targetTable.readDerived(null, getRequiredTenantId());
		return(targetRec);
	}
	@Override
	public void setRequiredOwnerTenant(ICFSecTenant argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setOwnerTenant", 1, "argObj");
		}
		else {
			requiredTenantId = argObj.getRequiredId();
		}
	}

	@Override
	public void setRequiredOwnerTenant(CFLibDbKeyHash256 argTenantId) {
		requiredTenantId = argTenantId;
	}

	@Override
	public ICFSecTSecGroup getRequiredContainerGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTSecGroupTable targetTable = targetBackingSchema.getTableTSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredContainerGroup", 0, "ICFSecSchema.getBackingCFSec().getTableTSecGroup()");
		}
		ICFSecTSecGroup targetRec = targetTable.readDerived(null, getRequiredTSecGroupId());
		return(targetRec);
	}
	@Override
	public void setRequiredContainerGroup(ICFSecTSecGroup argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setContainerGroup", 1, "argObj");
		}
		else {
			requiredTSecGroupId = argObj.getRequiredTSecGroupId();
		}
	}

	@Override
	public void setRequiredContainerGroup(CFLibDbKeyHash256 argTSecGroupId) {
		requiredTSecGroupId = argTSecGroupId;
	}

	@Override
	public ICFSecSecUser getRequiredParentUser() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentUser", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecUserTable targetTable = targetBackingSchema.getTableSecUser();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setRequiredParentUser", 0, "ICFSecSchema.getBackingCFSec().getTableSecUser()");
		}
		ICFSecSecUser targetRec = targetTable.readDerived(null, getRequiredSecUserId());
		return(targetRec);
	}
	@Override
	public void setRequiredParentUser(ICFSecSecUser argObj) {
		if(argObj == null) {
			throw new CFLibNullArgumentException(getClass(), "setParentUser", 1, "argObj");
		}
		else {
			requiredSecUserId = argObj.getRequiredSecUserId();
		}
	}

	@Override
	public void setRequiredParentUser(CFLibDbKeyHash256 argSecUserId) {
		requiredSecUserId = argSecUserId;
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTenantId() {
		return( requiredTenantId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredTSecGroupId() {
		return( requiredTSecGroupId );
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecUserId() {
		return( requiredSecUserId );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecTSecGrpMemb ) {
			ICFSecTSecGrpMemb rhs = (ICFSecTSecGrpMemb)obj;
			if( ! getCreatedByUserId().equals( rhs.getCreatedByUserId() ) ) {
				return( false );
			}
			if( ! getCreatedAt().equals( rhs.getCreatedAt() ) ) {
				return( false );
			}
			if( ! getUpdatedByUserId().equals( rhs.getUpdatedByUserId() ) ) {
				return( false );
			}
			if( ! getUpdatedAt().equals( rhs.getUpdatedAt() ) ) {
				return( false );
			}
			if( getRequiredTSecGrpMembId() != null ) {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					if( ! getRequiredTSecGrpMembId().equals( rhs.getRequiredTSecGrpMembId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembH ) {
			ICFSecTSecGrpMembH rhs = (ICFSecTSecGrpMembH)obj;
			if( getRequiredTSecGrpMembId() != null ) {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					if( ! getRequiredTSecGrpMembId().equals( rhs.getRequiredTSecGrpMembId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					return( false );
				}
			}
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembHPKey ) {
			ICFSecTSecGrpMembHPKey rhs = (ICFSecTSecGrpMembHPKey)obj;
			if( getRequiredTSecGrpMembId() != null ) {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					if( ! getRequiredTSecGrpMembId().equals( rhs.getRequiredTSecGrpMembId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGrpMembId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembByTenantIdxKey ) {
			ICFSecTSecGrpMembByTenantIdxKey rhs = (ICFSecTSecGrpMembByTenantIdxKey)obj;
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembByGroupIdxKey ) {
			ICFSecTSecGrpMembByGroupIdxKey rhs = (ICFSecTSecGrpMembByGroupIdxKey)obj;
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembByUserIdxKey ) {
			ICFSecTSecGrpMembByUserIdxKey rhs = (ICFSecTSecGrpMembByUserIdxKey)obj;
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecTSecGrpMembByUUserIdxKey ) {
			ICFSecTSecGrpMembByUUserIdxKey rhs = (ICFSecTSecGrpMembByUUserIdxKey)obj;
			if( getRequiredTenantId() != null ) {
				if( rhs.getRequiredTenantId() != null ) {
					if( ! getRequiredTenantId().equals( rhs.getRequiredTenantId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTenantId() != null ) {
					return( false );
				}
			}
			if( getRequiredTSecGroupId() != null ) {
				if( rhs.getRequiredTSecGroupId() != null ) {
					if( ! getRequiredTSecGroupId().equals( rhs.getRequiredTSecGroupId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredTSecGroupId() != null ) {
					return( false );
				}
			}
			if( getRequiredSecUserId() != null ) {
				if( rhs.getRequiredSecUserId() != null ) {
					if( ! getRequiredSecUserId().equals( rhs.getRequiredSecUserId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecUserId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			boolean retval = super.equals( obj );
			return( retval );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode = hashCode + getCreatedByUserId().hashCode();
		hashCode = hashCode + getCreatedAt().hashCode();
		hashCode = hashCode + getUpdatedByUserId().hashCode();
		hashCode = hashCode + getUpdatedAt().hashCode();
		hashCode = hashCode + getRequiredTSecGrpMembId().hashCode();
		hashCode = hashCode + getRequiredTenantId().hashCode();
		hashCode = hashCode + getRequiredTSecGroupId().hashCode();
		hashCode = hashCode + getRequiredSecUserId().hashCode();
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecTSecGrpMemb ) {
			ICFSecTSecGrpMemb rhs = (ICFSecTSecGrpMemb)obj;
			cmp = 0;
			{
				cmp = getCreatedByUserId().compareTo( rhs.getCreatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getCreatedAt().compareTo( rhs.getCreatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedByUserId().compareTo( rhs.getUpdatedByUserId() );
				if( cmp != 0 ) {
					return( cmp );
				}

				cmp = getUpdatedAt().compareTo( rhs.getUpdatedAt() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredTSecGrpMembId() != null) {
				if (rhs.getRequiredTSecGrpMembId() != null) {
					cmp = getRequiredTSecGrpMembId().compareTo( rhs.getRequiredTSecGrpMembId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpMembId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembHPKey ) {
			ICFSecTSecGrpMembHPKey rhs = (ICFSecTSecGrpMembHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredTSecGrpMembId() != null) {
				if (rhs.getRequiredTSecGrpMembId() != null) {
					cmp = getRequiredTSecGrpMembId().compareTo( rhs.getRequiredTSecGrpMembId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpMembId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembH ) {
			ICFSecTSecGrpMembH rhs = (ICFSecTSecGrpMembH)obj;
			cmp = 0;
			if (getRequiredTSecGrpMembId() != null) {
				if (rhs.getRequiredTSecGrpMembId() != null) {
					cmp = getRequiredTSecGrpMembId().compareTo( rhs.getRequiredTSecGrpMembId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGrpMembId() != null) {
				return( -1 );
			}
			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembByTenantIdxKey ) {
			ICFSecTSecGrpMembByTenantIdxKey rhs = (ICFSecTSecGrpMembByTenantIdxKey)obj;

			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembByGroupIdxKey ) {
			ICFSecTSecGrpMembByGroupIdxKey rhs = (ICFSecTSecGrpMembByGroupIdxKey)obj;

			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembByUserIdxKey ) {
			ICFSecTSecGrpMembByUserIdxKey rhs = (ICFSecTSecGrpMembByUserIdxKey)obj;

			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecTSecGrpMembByUUserIdxKey ) {
			ICFSecTSecGrpMembByUUserIdxKey rhs = (ICFSecTSecGrpMembByUUserIdxKey)obj;

			if (getRequiredTenantId() != null) {
				if (rhs.getRequiredTenantId() != null) {
					cmp = getRequiredTenantId().compareTo( rhs.getRequiredTenantId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTenantId() != null) {
				return( -1 );
			}
			if (getRequiredTSecGroupId() != null) {
				if (rhs.getRequiredTSecGroupId() != null) {
					cmp = getRequiredTSecGroupId().compareTo( rhs.getRequiredTSecGroupId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredTSecGroupId() != null) {
				return( -1 );
			}
			if (getRequiredSecUserId() != null) {
				if (rhs.getRequiredSecUserId() != null) {
					cmp = getRequiredSecUserId().compareTo( rhs.getRequiredSecUserId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecUserId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else {
			throw new CFLibUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				null );
		}
	}

	@Override
	public void set( ICFSecTSecGrpMemb src ) {
		setTSecGrpMemb( src );
	}

	@Override
	public void setTSecGrpMemb( ICFSecTSecGrpMemb src ) {
		setRequiredTSecGrpMembId(src.getRequiredTSecGrpMembId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredOwnerTenant(src.getRequiredOwnerTenant());
		setRequiredContainerGroup(src.getRequiredContainerGroup());
		setRequiredParentUser(src.getRequiredParentUser());
	}

	@Override
	public void set( ICFSecTSecGrpMembH src ) {
		setTSecGrpMemb( src );
	}

	@Override
	public void setTSecGrpMemb( ICFSecTSecGrpMembH src ) {
		setRequiredTSecGrpMembId(src.getRequiredTSecGrpMembId());
		setRequiredOwnerTenant(src.getRequiredTenantId());
		setRequiredContainerGroup(src.getRequiredTSecGroupId());
		setRequiredParentUser(src.getRequiredSecUserId());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredTSecGrpMembId=" + "\"" + getRequiredTSecGrpMembId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredTSecGrpMembId=" + "\"" + getRequiredTSecGrpMembId().toString() + "\""
			+ " RequiredTenantId=" + "\"" + getRequiredTenantId().toString() + "\""
			+ " RequiredTSecGroupId=" + "\"" + getRequiredTSecGroupId().toString() + "\""
			+ " RequiredSecUserId=" + "\"" + getRequiredSecUserId().toString() + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffTSecGrpMemb" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
