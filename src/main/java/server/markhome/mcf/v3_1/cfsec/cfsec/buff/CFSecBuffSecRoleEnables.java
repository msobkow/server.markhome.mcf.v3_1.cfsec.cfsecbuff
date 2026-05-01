// Description: Java 25 implementation of a SecRoleEnables buffer

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

public class CFSecBuffSecRoleEnables
	implements ICFSecSecRoleEnables, Comparable<Object>, Serializable
{
	protected ICFSecSecRoleEnablesPKey pkey = new CFSecBuffSecRoleEnablesPKey();
	protected int requiredRevision;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecRoleEnables.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecRoleEnables.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();

	public CFSecBuffSecRoleEnables() {
		pkey = new CFSecBuffSecRoleEnablesPKey();
	}

	@Override
	public ICFSecSecRoleEnablesPKey getPKey() {
		return pkey;
	}

	@Override
	public void setPKey(ICFSecSecRoleEnablesPKey pkey ) {
		if (pkey == null) {
			throw new CFLibNullArgumentException(getClass(), "setPKey", 1, "pkey");
		}
		else if (!(pkey instanceof CFSecBuffSecRoleEnablesPKey)) {
			throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffSecRoleEnablesPKey");
		}
		this.pkey = (CFSecBuffSecRoleEnablesPKey)pkey;
	}

	@Override
	public ICFSecSecRole getRequiredContainerRole() {
		return( getPKey().getRequiredContainerRole() );
	}
	
	@Override
	public void setRequiredContainerRole(ICFSecSecRole value) {
		getPKey().setRequiredContainerRole(value);
	}

	@Override
	public void setRequiredContainerRole(CFLibDbKeyHash256 argSecRoleId) {
		getPKey().setRequiredContainerRole(argSecRoleId);
	}

	@Override
	public CFLibDbKeyHash256 getRequiredSecRoleId() {
		return (getPKey().getRequiredContainerRole().getRequiredSecRoleId());
	}

	@Override
	public ICFSecSecSysGrp getRequiredParentEnableGroup() {
		return( getPKey().getRequiredParentEnableGroup() );
	}
	
	@Override
	public void setRequiredParentEnableGroup(ICFSecSecSysGrp value) {
		getPKey().setRequiredParentEnableGroup(value);
	}

	@Override
	public void setRequiredParentEnableGroup(String argEnableName) {
		getPKey().setRequiredParentEnableGroup(argEnableName);
	}

	@Override
	public String getRequiredEnableName() {
		return (getPKey().getRequiredParentEnableGroup().getRequiredName());
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
		return( ICFSecSecRoleEnables.CLASS_CODE );
	}

	@Override
	public boolean equals( Object obj ) {
		if( obj == null ) {
			return( false );
		}
		else if( obj instanceof ICFSecSecRoleEnables ) {
			ICFSecSecRoleEnables rhs = (ICFSecSecRoleEnables)obj;
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
			if( getRequiredSecRoleId() != null ) {
				if( rhs.getRequiredSecRoleId() != null ) {
					if( ! getRequiredSecRoleId().equals( rhs.getRequiredSecRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecRoleEnablesH ) {
			ICFSecSecRoleEnablesH rhs = (ICFSecSecRoleEnablesH)obj;
			if( getRequiredSecRoleId() != null ) {
				if( rhs.getRequiredSecRoleId() != null ) {
					if( ! getRequiredSecRoleId().equals( rhs.getRequiredSecRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecRoleEnablesHPKey ) {
			ICFSecSecRoleEnablesHPKey rhs = (ICFSecSecRoleEnablesHPKey)obj;
			if( getRequiredSecRoleId() != null ) {
				if( rhs.getRequiredSecRoleId() != null ) {
					if( ! getRequiredSecRoleId().equals( rhs.getRequiredSecRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecRoleEnablesByRoleIdxKey ) {
			ICFSecSecRoleEnablesByRoleIdxKey rhs = (ICFSecSecRoleEnablesByRoleIdxKey)obj;
			if( getRequiredSecRoleId() != null ) {
				if( rhs.getRequiredSecRoleId() != null ) {
					if( ! getRequiredSecRoleId().equals( rhs.getRequiredSecRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecRoleId() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if( obj instanceof ICFSecSecRoleEnablesByNameIdxKey ) {
			ICFSecSecRoleEnablesByNameIdxKey rhs = (ICFSecSecRoleEnablesByNameIdxKey)obj;
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
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
		hashCode = hashCode + getRequiredSecRoleId().hashCode();
		if( getRequiredEnableName() != null ) {
			hashCode = hashCode + getRequiredEnableName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if( obj == null ) {
			return( -1 );
		}
		else if( obj instanceof ICFSecSecRoleEnables ) {
			ICFSecSecRoleEnables rhs = (ICFSecSecRoleEnables)obj;
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
			if (getRequiredSecRoleId() != null) {
				if (rhs.getRequiredSecRoleId() != null) {
					cmp = getRequiredSecRoleId().compareTo( rhs.getRequiredSecRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecRoleEnablesHPKey ) {
			ICFSecSecRoleEnablesHPKey rhs = (ICFSecSecRoleEnablesHPKey)obj;
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if (getRequiredSecRoleId() != null) {
				if (rhs.getRequiredSecRoleId() != null) {
					cmp = getRequiredSecRoleId().compareTo( rhs.getRequiredSecRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecRoleEnablesH ) {
			ICFSecSecRoleEnablesH rhs = (ICFSecSecRoleEnablesH)obj;
			cmp = 0;
			if (getRequiredSecRoleId() != null) {
				if (rhs.getRequiredSecRoleId() != null) {
					cmp = getRequiredSecRoleId().compareTo( rhs.getRequiredSecRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if( obj instanceof ICFSecSecRoleEnablesByRoleIdxKey ) {
			ICFSecSecRoleEnablesByRoleIdxKey rhs = (ICFSecSecRoleEnablesByRoleIdxKey)obj;

			if (getRequiredSecRoleId() != null) {
				if (rhs.getRequiredSecRoleId() != null) {
					cmp = getRequiredSecRoleId().compareTo( rhs.getRequiredSecRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecRoleId() != null) {
				return( -1 );
			}			return( 0 );
		}
		else if( obj instanceof ICFSecSecRoleEnablesByNameIdxKey ) {
			ICFSecSecRoleEnablesByNameIdxKey rhs = (ICFSecSecRoleEnablesByNameIdxKey)obj;

			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
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
	public void set( ICFSecSecRoleEnables src ) {
		setSecRoleEnables( src );
	}

	@Override
	public void setSecRoleEnables( ICFSecSecRoleEnables src ) {
		setRequiredContainerRole(src.getRequiredContainerRole());
		setRequiredParentEnableGroup(src.getRequiredParentEnableGroup());
		setRequiredRevision( src.getRequiredRevision() );
		setCreatedByUserId( src.getCreatedByUserId() );
		setCreatedAt( src.getCreatedAt() );
		setUpdatedByUserId( src.getUpdatedByUserId() );
		setUpdatedAt( src.getUpdatedAt() );
	}

	@Override
	public void set( ICFSecSecRoleEnablesH src ) {
		setSecRoleEnables( src );
	}

	@Override
	public void setSecRoleEnables( ICFSecSecRoleEnablesH src ) {
		setRequiredContainerRole(src.getRequiredSecRoleId());
		setRequiredParentEnableGroup(src.getRequiredEnableName());
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredSecRoleId=" + "\"" + getRequiredSecRoleId().toString() + "\""
			+ " RequiredEnableName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnableName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<CFSecBuffSecRoleEnables" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
