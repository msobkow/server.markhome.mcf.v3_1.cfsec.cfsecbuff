// Description: Java 25 implementation of a SecUser history buffer object

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

public class CFSecBuffSecUserH
    implements ICFSecSecUserH, Comparable<Object>, Serializable
{
    protected CFSecBuffSecUserHPKey pkey;
	protected CFLibDbKeyHash256 createdByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_CREATED_BY);
	protected LocalDateTime createdAt = LocalDateTime.now();
	protected CFLibDbKeyHash256 updatedByUserId = CFLibDbKeyHash256.fromHex(ICFSecSecUser.S_INIT_UPDATED_BY);
	protected LocalDateTime updatedAt = LocalDateTime.now();
	protected String requiredLoginId;
	protected String requiredDfltSysGrpName;
	protected String requiredDfltClusGrpName;
	protected String requiredDfltTentGrpName;
	protected String requiredEMailAddress;
	protected CFLibUuid6 optionalEMailConfirmUuid6;
	protected String requiredPasswordHash;
	protected CFLibUuid6 optionalPasswordResetUuid6;

    public CFSecBuffSecUserH() {
            // The primary key member attributes are initialized on construction
            pkey = new CFSecBuffSecUserHPKey();
		requiredLoginId = ICFSecSecUser.LOGINID_INIT_VALUE;
		requiredDfltSysGrpName = ICFSecSecUser.DFLTSYSGRPNAME_INIT_VALUE;
		requiredDfltClusGrpName = ICFSecSecUser.DFLTCLUSGRPNAME_INIT_VALUE;
		requiredDfltTentGrpName = ICFSecSecUser.DFLTTENTGRPNAME_INIT_VALUE;
		requiredEMailAddress = ICFSecSecUser.EMAILADDRESS_INIT_VALUE;
		optionalEMailConfirmUuid6 = null;
		optionalPasswordResetUuid6 = null;
    }

    @Override
    public int getClassCode() {
            return( ICFSecSecUser.CLASS_CODE );
    }

    @Override
    public CFLibDbKeyHash256 getCreatedByUserId() {
        return( createdByUserId );
    }

    @Override
    public void setCreatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedByUserId", 1, "value");
        }
        createdByUserId = value;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return( createdAt );
    }

    @Override
    public void setCreatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setCreatedAt", 1, "value");
        }
        createdAt = value;
    }

    @Override
    public CFLibDbKeyHash256 getUpdatedByUserId() {
        return( updatedByUserId );
    }

    @Override
    public void setUpdatedByUserId( CFLibDbKeyHash256 value ) {
        if (value == null || value.isNull()) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedByUserId", 1, "value");
        }
        updatedByUserId = value;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return( updatedAt );
    }

    @Override
    public void setUpdatedAt( LocalDateTime value ) {
        if (value == null) {
            throw new CFLibNullArgumentException(getClass(), "setUpdatedAt", 1, "value");
        }
        updatedAt = value;
    }

    @Override
    public ICFSecSecUserHPKey getPKey() {
        return( pkey );
    }

    @Override
    public void setPKey( ICFSecSecUserHPKey pkey ) {
        if (pkey != null) {
            if (pkey instanceof CFSecBuffSecUserHPKey) {
                this.pkey = (CFSecBuffSecUserHPKey)pkey;
            }
            else {
                throw new CFLibUnsupportedClassException(getClass(), "setPKey", "pkey", pkey, "CFSecBuffSecUserHPKey");
            }
        }
    }

    @Override
    public CFLibDbKeyHash256 getAuditClusterId() {
        return pkey.getAuditClusterId();
    }

    @Override
    public void setAuditClusterId(CFLibDbKeyHash256 auditClusterId) {
        pkey.setAuditClusterId(auditClusterId);
    }

    @Override
    public LocalDateTime getAuditStamp() {
        return pkey.getAuditStamp();
    }

    @Override
    public void setAuditStamp(LocalDateTime auditStamp) {
        pkey.setAuditStamp(auditStamp);
    }

    @Override
    public short getAuditActionId() {
        return pkey.getAuditActionId();
    }

    @Override
    public void setAuditActionId(short auditActionId) {
        pkey.setAuditActionId(auditActionId);
    }

    @Override
    public int getRequiredRevision() {
        return pkey.getRequiredRevision();
    }

    @Override
    public void setRequiredRevision(int revision) {
        pkey.setRequiredRevision(revision);
    }

    @Override
    public CFLibDbKeyHash256 getAuditSessionId() {
        return pkey.getAuditSessionId();
    }

    @Override
    public void setAuditSessionId(CFLibDbKeyHash256 auditSessionId) {
        pkey.setAuditSessionId(auditSessionId);
    }

    @Override
    public CFLibDbKeyHash256 getRequiredSecUserId() {
        return( pkey.getRequiredSecUserId() );
    }

    @Override
    public void setRequiredSecUserId( CFLibDbKeyHash256 requiredSecUserId ) {
        pkey.setRequiredSecUserId( requiredSecUserId );
    }

	@Override
	public String getRequiredLoginId() {
		return( requiredLoginId );
	}

	@Override
	public void setRequiredLoginId( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredLoginId",
				1,
				"value" );
		}
		else if( value.length() > 32 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredLoginId",
				1,
				"value.length()",
				value.length(),
				32 );
		}
		requiredLoginId = value;
	}

	@Override
	public String getRequiredDfltSysGrpName() {
		return( requiredDfltSysGrpName );
	}

	@Override
	public void setRequiredDfltSysGrpName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDfltSysGrpName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDfltSysGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredDfltSysGrpName = value;
	}

	@Override
	public String getRequiredDfltClusGrpName() {
		return( requiredDfltClusGrpName );
	}

	@Override
	public void setRequiredDfltClusGrpName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDfltClusGrpName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDfltClusGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredDfltClusGrpName = value;
	}

	@Override
	public String getRequiredDfltTentGrpName() {
		return( requiredDfltTentGrpName );
	}

	@Override
	public void setRequiredDfltTentGrpName( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredDfltTentGrpName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredDfltTentGrpName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredDfltTentGrpName = value;
	}

	@Override
	public String getRequiredEMailAddress() {
		return( requiredEMailAddress );
	}

	@Override
	public void setRequiredEMailAddress( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value" );
		}
		else if( value.length() > 512 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredEMailAddress",
				1,
				"value.length()",
				value.length(),
				512 );
		}
		requiredEMailAddress = value;
	}

	@Override
	public CFLibUuid6 getOptionalEMailConfirmUuid6() {
		return( optionalEMailConfirmUuid6 );
	}

	@Override
	public void setOptionalEMailConfirmUuid6( CFLibUuid6 value ) {
		optionalEMailConfirmUuid6 = value;
	}

	@Override
	public String getRequiredPasswordHash() {
		return( requiredPasswordHash );
	}

	@Override
	public void setRequiredPasswordHash( String value ) {
		if( value == null ) {
			throw new CFLibNullArgumentException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value" );
		}
		else if( value.length() > 256 ) {
			throw new CFLibArgumentOverflowException( getClass(),
				"setRequiredPasswordHash",
				1,
				"value.length()",
				value.length(),
				256 );
		}
		requiredPasswordHash = value;
	}

	@Override
	public CFLibUuid6 getOptionalPasswordResetUuid6() {
		return( optionalPasswordResetUuid6 );
	}

	@Override
	public void setOptionalPasswordResetUuid6( CFLibUuid6 value ) {
		optionalPasswordResetUuid6 = value;
	}

    @Override
    public boolean equals( Object obj ) {
        if (obj == null) {
            return( false );
        }
        else if (obj instanceof ICFSecSecUser) {
            ICFSecSecUser rhs = (ICFSecSecUser)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
		}

			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltSysGrpName() != null ) {
				if( rhs.getRequiredDfltSysGrpName() != null ) {
					if( ! getRequiredDfltSysGrpName().equals( rhs.getRequiredDfltSysGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltSysGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltClusGrpName() != null ) {
				if( rhs.getRequiredDfltClusGrpName() != null ) {
					if( ! getRequiredDfltClusGrpName().equals( rhs.getRequiredDfltClusGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltClusGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltTentGrpName() != null ) {
				if( rhs.getRequiredDfltTentGrpName() != null ) {
					if( ! getRequiredDfltTentGrpName().equals( rhs.getRequiredDfltTentGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltTentGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailAddress() != null ) {
				if( rhs.getRequiredEMailAddress() != null ) {
					if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailAddress() != null ) {
					return( false );
				}
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
			if( getRequiredPasswordHash() != null ) {
				if( rhs.getRequiredPasswordHash() != null ) {
					if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordHash() != null ) {
					return( false );
				}
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecUserH) {
            ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() != null) {
				if (!getPKey().equals(rhs.getPKey())) {
					return( false );
				}
			}
			else {
				return( false );
			}
		}
		else if (rhs.getPKey() != null) {
			return( false );
		}

			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltSysGrpName() != null ) {
				if( rhs.getRequiredDfltSysGrpName() != null ) {
					if( ! getRequiredDfltSysGrpName().equals( rhs.getRequiredDfltSysGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltSysGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltClusGrpName() != null ) {
				if( rhs.getRequiredDfltClusGrpName() != null ) {
					if( ! getRequiredDfltClusGrpName().equals( rhs.getRequiredDfltClusGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltClusGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredDfltTentGrpName() != null ) {
				if( rhs.getRequiredDfltTentGrpName() != null ) {
					if( ! getRequiredDfltTentGrpName().equals( rhs.getRequiredDfltTentGrpName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredDfltTentGrpName() != null ) {
					return( false );
				}
			}
			if( getRequiredEMailAddress() != null ) {
				if( rhs.getRequiredEMailAddress() != null ) {
					if( ! getRequiredEMailAddress().equals( rhs.getRequiredEMailAddress() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEMailAddress() != null ) {
					return( false );
				}
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
			if( getRequiredPasswordHash() != null ) {
				if( rhs.getRequiredPasswordHash() != null ) {
					if( ! getRequiredPasswordHash().equals( rhs.getRequiredPasswordHash() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredPasswordHash() != null ) {
					return( false );
				}
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecUserHPKey) {
		ICFSecSecUserHPKey rhs = (ICFSecSecUserHPKey)obj;
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
        else if (obj instanceof ICFSecSecUserByULoginIdxKey) {
            ICFSecSecUserByULoginIdxKey rhs = (ICFSecSecUserByULoginIdxKey)obj;
			if( getRequiredLoginId() != null ) {
				if( rhs.getRequiredLoginId() != null ) {
					if( ! getRequiredLoginId().equals( rhs.getRequiredLoginId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredLoginId() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecUserByEMConfIdxKey) {
            ICFSecSecUserByEMConfIdxKey rhs = (ICFSecSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					if( ! getOptionalEMailConfirmUuid6().equals( rhs.getOptionalEMailConfirmUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else if (obj instanceof ICFSecSecUserByPwdResetIdxKey) {
            ICFSecSecUserByPwdResetIdxKey rhs = (ICFSecSecUserByPwdResetIdxKey)obj;
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					if( ! getOptionalPasswordResetUuid6().equals( rhs.getOptionalPasswordResetUuid6() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( false );
				}
			}
            return( true );
        }
        else {
			return( false );
        }
    }
    
    @Override
    public int hashCode() {
        int hashCode = pkey.hashCode();
		if( getRequiredLoginId() != null ) {
			hashCode = hashCode + getRequiredLoginId().hashCode();
		}
		if( getRequiredDfltSysGrpName() != null ) {
			hashCode = hashCode + getRequiredDfltSysGrpName().hashCode();
		}
		if( getRequiredDfltClusGrpName() != null ) {
			hashCode = hashCode + getRequiredDfltClusGrpName().hashCode();
		}
		if( getRequiredDfltTentGrpName() != null ) {
			hashCode = hashCode + getRequiredDfltTentGrpName().hashCode();
		}
		if( getRequiredEMailAddress() != null ) {
			hashCode = hashCode + getRequiredEMailAddress().hashCode();
		}
		if( getOptionalEMailConfirmUuid6() != null ) {
			hashCode = hashCode + getOptionalEMailConfirmUuid6().hashCode();
		}
		if( getRequiredPasswordHash() != null ) {
			hashCode = hashCode + getRequiredPasswordHash().hashCode();
		}
		if( getOptionalPasswordResetUuid6() != null ) {
			hashCode = hashCode + getOptionalPasswordResetUuid6().hashCode();
		}
        return( hashCode & 0x7fffffff );
    }

    @Override
    public int compareTo( Object obj ) {
        int cmp;
        if (obj == null) {
            return( 1 );
        }
        else if (obj instanceof ICFSecSecUser) {
		ICFSecSecUser rhs = (ICFSecSecUser)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
		}
			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}
			if (getRequiredDfltSysGrpName() != null) {
				if (rhs.getRequiredDfltSysGrpName() != null) {
					cmp = getRequiredDfltSysGrpName().compareTo( rhs.getRequiredDfltSysGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltSysGrpName() != null) {
				return( -1 );
			}
			if (getRequiredDfltClusGrpName() != null) {
				if (rhs.getRequiredDfltClusGrpName() != null) {
					cmp = getRequiredDfltClusGrpName().compareTo( rhs.getRequiredDfltClusGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltClusGrpName() != null) {
				return( -1 );
			}
			if (getRequiredDfltTentGrpName() != null) {
				if (rhs.getRequiredDfltTentGrpName() != null) {
					cmp = getRequiredDfltTentGrpName().compareTo( rhs.getRequiredDfltTentGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltTentGrpName() != null) {
				return( -1 );
			}
			if (getRequiredEMailAddress() != null) {
				if (rhs.getRequiredEMailAddress() != null) {
					cmp = getRequiredEMailAddress().compareTo( rhs.getRequiredEMailAddress() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailAddress() != null) {
				return( -1 );
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPasswordHash() != null) {
				if (rhs.getRequiredPasswordHash() != null) {
					cmp = getRequiredPasswordHash().compareTo( rhs.getRequiredPasswordHash() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordHash() != null) {
				return( -1 );
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserHPKey) {
        if (getPKey() != null) {
            return( getPKey().compareTo( obj ));
        }
        else {
            return( -1 );
        }
        }
        else if (obj instanceof ICFSecSecUserH) {
		ICFSecSecUserH rhs = (ICFSecSecUserH)obj;
		if (getPKey() != null) {
			if (rhs.getPKey() == null) {
				return( 1 );
			}
			else {
				cmp = getPKey().compareTo(rhs.getPKey());
				if (cmp != 0) {
					return( cmp );
				}
			}
		}
		else {
			if (rhs.getPKey() != null) {
				return( -1 );
			}
		}
			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}
			if (getRequiredDfltSysGrpName() != null) {
				if (rhs.getRequiredDfltSysGrpName() != null) {
					cmp = getRequiredDfltSysGrpName().compareTo( rhs.getRequiredDfltSysGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltSysGrpName() != null) {
				return( -1 );
			}
			if (getRequiredDfltClusGrpName() != null) {
				if (rhs.getRequiredDfltClusGrpName() != null) {
					cmp = getRequiredDfltClusGrpName().compareTo( rhs.getRequiredDfltClusGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltClusGrpName() != null) {
				return( -1 );
			}
			if (getRequiredDfltTentGrpName() != null) {
				if (rhs.getRequiredDfltTentGrpName() != null) {
					cmp = getRequiredDfltTentGrpName().compareTo( rhs.getRequiredDfltTentGrpName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredDfltTentGrpName() != null) {
				return( -1 );
			}
			if (getRequiredEMailAddress() != null) {
				if (rhs.getRequiredEMailAddress() != null) {
					cmp = getRequiredEMailAddress().compareTo( rhs.getRequiredEMailAddress() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEMailAddress() != null) {
				return( -1 );
			}
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}
			if (getRequiredPasswordHash() != null) {
				if (rhs.getRequiredPasswordHash() != null) {
					cmp = getRequiredPasswordHash().compareTo( rhs.getRequiredPasswordHash() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredPasswordHash() != null) {
				return( -1 );
			}
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserByULoginIdxKey ) {
            ICFSecSecUserByULoginIdxKey rhs = (ICFSecSecUserByULoginIdxKey)obj;
			if (getRequiredLoginId() != null) {
				if (rhs.getRequiredLoginId() != null) {
					cmp = getRequiredLoginId().compareTo( rhs.getRequiredLoginId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredLoginId() != null) {
				return( -1 );
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserByEMConfIdxKey ) {
            ICFSecSecUserByEMConfIdxKey rhs = (ICFSecSecUserByEMConfIdxKey)obj;
			if( getOptionalEMailConfirmUuid6() != null ) {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					cmp = getOptionalEMailConfirmUuid6().compareTo( rhs.getOptionalEMailConfirmUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalEMailConfirmUuid6() != null ) {
					return( -1 );
				}
			}
            return( 0 );
        }
        else if (obj instanceof ICFSecSecUserByPwdResetIdxKey ) {
            ICFSecSecUserByPwdResetIdxKey rhs = (ICFSecSecUserByPwdResetIdxKey)obj;
			if( getOptionalPasswordResetUuid6() != null ) {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					cmp = getOptionalPasswordResetUuid6().compareTo( rhs.getOptionalPasswordResetUuid6() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else {
				if( rhs.getOptionalPasswordResetUuid6() != null ) {
					return( -1 );
				}
			}
            return( 0 );
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
    public void set( ICFSecSecUser src ) {
		setSecUser( src );
    }

	@Override
    public void setSecUser( ICFSecSecUser src ) {
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredDfltSysGrpName( src.getRequiredDfltSysGrpName() );
		setRequiredDfltClusGrpName( src.getRequiredDfltClusGrpName() );
		setRequiredDfltTentGrpName( src.getRequiredDfltTentGrpName() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setOptionalEMailConfirmUuid6( src.getOptionalEMailConfirmUuid6() );
		setRequiredPasswordHash( src.getRequiredPasswordHash() );
		setOptionalPasswordResetUuid6( src.getOptionalPasswordResetUuid6() );
		setRequiredRevision( src.getRequiredRevision() );
    }

	@Override
    public void set( ICFSecSecUserH src ) {
		setSecUser( src );
    }

	@Override
    public void setSecUser( ICFSecSecUserH src ) {
		setRequiredSecUserId( src.getRequiredSecUserId() );
		setRequiredLoginId( src.getRequiredLoginId() );
		setRequiredDfltSysGrpName( src.getRequiredDfltSysGrpName() );
		setRequiredDfltClusGrpName( src.getRequiredDfltClusGrpName() );
		setRequiredDfltTentGrpName( src.getRequiredDfltTentGrpName() );
		setRequiredEMailAddress( src.getRequiredEMailAddress() );
		setOptionalEMailConfirmUuid6( src.getOptionalEMailConfirmUuid6() );
		setRequiredPasswordHash( src.getRequiredPasswordHash() );
		setOptionalPasswordResetUuid6( src.getOptionalPasswordResetUuid6() );
		setRequiredRevision( src.getRequiredRevision() );
    }

    public String getXmlAttrFragment() {
        String ret = pkey.getXmlAttrFragment() 
			+ " RequiredRevision=\"" + Integer.toString( getRequiredRevision() ) + "\""
			+ " RequiredLoginId=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredLoginId() ) + "\""
			+ " RequiredDfltSysGrpName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredDfltSysGrpName() ) + "\""
			+ " RequiredDfltClusGrpName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredDfltClusGrpName() ) + "\""
			+ " RequiredDfltTentGrpName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredDfltTentGrpName() ) + "\""
			+ " RequiredEMailAddress=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEMailAddress() ) + "\""
			+ " OptionalEMailConfirmUuid6=" + ( ( getOptionalEMailConfirmUuid6() == null ) ? "null" : "\"" + getOptionalEMailConfirmUuid6().toString() + "\"" )
			+ " RequiredPasswordHash=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredPasswordHash() ) + "\""
			+ " OptionalPasswordResetUuid6=" + ( ( getOptionalPasswordResetUuid6() == null ) ? "null" : "\"" + getOptionalPasswordResetUuid6().toString() + "\"" );
        return( ret );
    }

    public String toString() {
        String ret = "<CFSecBuffSecUserH" + getXmlAttrFragment() + "/>";
        return( ret );
    }
}
