// Description: Java 25 implementation of a Cluster buffer

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

public class CFSecBuffCluster
	implements ICFSecCluster, Comparable<Object>, Serializable
{
	protected CFLibDbKeyHash256 requiredId;
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecCluster.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecCluster.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredFullDomName;
	protected String requiredDescription;

	public CFSecBuffCluster() {
		requiredId = CFLibDbKeyHash256.fromHex( ICFSecCluster.ID_INIT_VALUE.toString() );
		requiredFullDomName = ICFSecCluster.FULLDOMNAME_INIT_VALUE;
		requiredDescription = ICFSecCluster.DESCRIPTION_INIT_VALUE;
	}

	@Override
	public CFLibDbKeyHash256 getPKey() {
		return getRequiredId();
	}

	@Override
	public void setPKey(CFLibDbKeyHash256 requiredId) {
		if (requiredId != null) {
			setRequiredId(requiredId);
		}
	}

	@Override
	public CFLibDbKeyHash256 getRequiredId() {
		return( requiredId );
	}

	@Override
	public void setRequiredId( CFLibDbKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredId",
				1,
				"value" );
		}
		requiredId = value;
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
		return( ICFSecCluster.CLASS_CODE );
	}

	@Override
	public List<ICFSecHostNode> getOptionalComponentsHostNode() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsHostNode", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecHostNodeTable targetTable = targetBackingSchema.getTableHostNode();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsHostNode", 0, "ICFSecSchema.getBackingCFSec().getTableHostNode()");
		}
		ICFSecHostNode[] targetArr = targetTable.readDerivedByClusterIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFSecHostNode> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecHostNode> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecTenant> getOptionalComponentsTenant() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsTenant", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecTenantTable targetTable = targetBackingSchema.getTableTenant();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsTenant", 0, "ICFSecSchema.getBackingCFSec().getTableTenant()");
		}
		ICFSecTenant[] targetArr = targetTable.readDerivedByClusterIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFSecTenant> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecTenant> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecSecGroup> getOptionalComponentsSecGroup() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSecGroup", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSecGroupTable targetTable = targetBackingSchema.getTableSecGroup();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSecGroup", 0, "ICFSecSchema.getBackingCFSec().getTableSecGroup()");
		}
		ICFSecSecGroup[] targetArr = targetTable.readDerivedByClusterIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFSecSecGroup> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecSecGroup> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public List<ICFSecSysCluster> getOptionalComponentsSysCluster() {
		ICFSecSchema targetBackingSchema = ICFSecSchema.getBackingCFSec();
		if (targetBackingSchema == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSysCluster", 0, "ICFSecSchema.getBackingCFSec()");
		}
		ICFSecSysClusterTable targetTable = targetBackingSchema.getTableSysCluster();
		if (targetTable == null) {
			throw new CFLibNullArgumentException(getClass(), "setOptionalComponentsSysCluster", 0, "ICFSecSchema.getBackingCFSec().getTableSysCluster()");
		}
		ICFSecSysCluster[] targetArr = targetTable.readDerivedByClusterIdx(null, getRequiredId());
		if( targetArr != null ) {
			List<ICFSecSysCluster> results = new ArrayList<>(targetArr.length);
			for (int idx = 0; idx < targetArr.length; idx++) {
				results.add(targetArr[idx]);
			}
			return( results );
		}
		else {
			List<ICFSecSysCluster> results = new ArrayList<>();
			return( results );
		}
	}
	@Override
	public String getRequiredFullDomName() {
		return( requiredFullDomName );
	}

	@Override
	public void setRequiredFullDomName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredFullDomName",
				1,
				"value" );
		}
		else if( value.length() > 192 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredFullDomName",
				1,
				"value.length()",
				value.length(),
				192 );
		}
		requiredFullDomName = value;
	}

	@Override
	public String getRequiredDescription() {
		return( requiredDescription );
	}

	@Override
	public void setRequiredDescription( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDescription",
				1,
				"value" );
		}
		else if( value.length() > 128 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDescription",
				1,
				"value.length()",
				value.length(),
				128 );
		}
		requiredDescription = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecCluster ) {
			ICFSecCluster rhs = (ICFSecCluster)obj;
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
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredFullDomName() != null ) {
				if( rhs.getRequiredFullDomName() != null ) {
					if( ! getRequiredFullDomName().equals( rhs.getRequiredFullDomName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFullDomName() != null ) {
					return( false );
				}
			}
			if( getRequiredDescription() != null ) {
				if( rhs.getRequiredDescription() != null ) {
					if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecClusterH ) {
			ICFSecClusterH rhs = (ICFSecClusterH)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			if( getRequiredFullDomName() != null ) {
				if( rhs.getRequiredFullDomName() != null ) {
					if( ! getRequiredFullDomName().equals( rhs.getRequiredFullDomName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFullDomName() != null ) {
					return( false );
				}
			}
			if( getRequiredDescription() != null ) {
				if( rhs.getRequiredDescription() != null ) {
					if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDescription() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecClusterHPKey ) {
			ICFSecClusterHPKey rhs = (ICFSecClusterHPKey)obj;
			if( getRequiredId() != null ) {
				if( rhs.getRequiredId() != null ) {
					if( ! getRequiredId().equals( rhs.getRequiredId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecClusterByUDomNameIdxKey ) {
			ICFSecClusterByUDomNameIdxKey rhs = (ICFSecClusterByUDomNameIdxKey)obj;
			if( getRequiredFullDomName() != null ) {
				if( rhs.getRequiredFullDomName() != null ) {
					if( ! getRequiredFullDomName().equals( rhs.getRequiredFullDomName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredFullDomName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecClusterByUDescrIdxKey ) {
			ICFSecClusterByUDescrIdxKey rhs = (ICFSecClusterByUDescrIdxKey)obj;
			if( getRequiredDescription() != null ) {
				if( rhs.getRequiredDescription() != null ) {
					if( ! getRequiredDescription().equals( rhs.getRequiredDescription() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDescription() != null ) {
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
		hashCode = hashCode + getRequiredId().hashCode();
		if( getRequiredFullDomName() != null ) {
			hashCode = hashCode + getRequiredFullDomName().hashCode();
		}
		if( getRequiredDescription() != null ) {
			hashCode = hashCode + getRequiredDescription().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecCluster ) {
			ICFSecCluster rhs = (ICFSecCluster)obj;
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
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			if (getRequiredFullDomName() != null) {
				if (rhs.getRequiredFullDomName() != null) {
					cmp = getRequiredFullDomName().compareTo( rhs.getRequiredFullDomName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFullDomName() != null) {
				return( -1 );
			}
			if (getRequiredDescription() != null) {
				if (rhs.getRequiredDescription() != null) {
					cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDescription() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecClusterHPKey ) {
			ICFSecClusterHPKey rhs = (ICFSecClusterHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecClusterH ) {
			ICFSecClusterH rhs = (ICFSecClusterH)obj;
			cmp = 0;
			if (getRequiredId() != null) {
				if (rhs.getRequiredId() != null) {
					cmp = getRequiredId().compareTo( rhs.getRequiredId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredId() != null) {
				return( -1 );
			}
			if (getRequiredFullDomName() != null) {
				if (rhs.getRequiredFullDomName() != null) {
					cmp = getRequiredFullDomName().compareTo( rhs.getRequiredFullDomName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFullDomName() != null) {
				return( -1 );
			}
			if (getRequiredDescription() != null) {
				if (rhs.getRequiredDescription() != null) {
					cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDescription() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecClusterByUDomNameIdxKey ) {
			ICFSecClusterByUDomNameIdxKey rhs = (ICFSecClusterByUDomNameIdxKey)obj;

			if (getRequiredFullDomName() != null) {
				if (rhs.getRequiredFullDomName() != null) {
					cmp = getRequiredFullDomName().compareTo( rhs.getRequiredFullDomName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredFullDomName() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecClusterByUDescrIdxKey ) {
			ICFSecClusterByUDescrIdxKey rhs = (ICFSecClusterByUDescrIdxKey)obj;

			if (getRequiredDescription() != null) {
				if (rhs.getRequiredDescription() != null) {
					cmp = getRequiredDescription().compareTo( rhs.getRequiredDescription() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDescription() != null) {
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
	public void set( ICFSecCluster src ) {
		setCluster( src );
	}

	@Override
	public void setCluster( ICFSecCluster src ) {
		setRequiredId(src.getRequiredId());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
		setRequiredFullDomName(src.getRequiredFullDomName());
		setRequiredDescription(src.getRequiredDescription());
	}

	@Override
	public void set( ICFSecClusterH src ) {
		setCluster( src );
	}

	@Override
	public void setCluster( ICFSecClusterH src ) {
		setRequiredId(src.getRequiredId());
		setRequiredFullDomName(src.getRequiredFullDomName());
		setRequiredDescription(src.getRequiredDescription());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = ""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredId=" + "\"" + getRequiredId().toString() + "\""
			+ " RequiredFullDomName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredFullDomName() ) + "\""
			+ " RequiredDescription=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredDescription() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffCluster" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
