
// Description: Java 25 Default Factory implementation for SecUserPassword buffers

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
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.xml.CFLibXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsec.*;

/*
 *	CFSecBuffSecUserPasswordFactory implementation of ICFSecSecUserPasswordFactory for SecUserPassword
 */
public class CFSecBuffSecUserPasswordDefaultFactory
	implements ICFSecSecUserPasswordFactory
{
	public CFSecBuffSecUserPasswordDefaultFactory() {
	}

	@Override
	public ICFSecSecUserPasswordBySetStampIdxKey newBySetStampIdxKey() {
		ICFSecSecUserPasswordBySetStampIdxKey key =
			new CFSecBuffSecUserPasswordBySetStampIdxKey();
		return( key );
	}

	public CFSecBuffSecUserPasswordBySetStampIdxKey ensureBySetStampIdxKey(ICFSecSecUserPasswordBySetStampIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof CFSecBuffSecUserPasswordBySetStampIdxKey) {
			return( (CFSecBuffSecUserPasswordBySetStampIdxKey)key );
		}
		else {
			CFSecBuffSecUserPasswordBySetStampIdxKey mapped = new CFSecBuffSecUserPasswordBySetStampIdxKey();
			mapped.setRequiredPWSetStamp( key.getRequiredPWSetStamp() );
			return( mapped );
		}
	}

	@Override
	public ICFSecSecUserPassword newRec() {
		ICFSecSecUserPassword rec =
			new CFSecBuffSecUserPassword();
		return( rec );
	}

	public CFSecBuffSecUserPassword ensureRec(ICFSecSecUserPassword rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof CFSecBuffSecUserPassword) {
			return( (CFSecBuffSecUserPassword)rec );
		}
		else {
			CFSecBuffSecUserPassword mapped = new CFSecBuffSecUserPassword();
			mapped.set(rec);
			return( mapped );
		}
	}
}
