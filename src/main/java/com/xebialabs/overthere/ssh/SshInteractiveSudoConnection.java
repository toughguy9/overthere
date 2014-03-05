/*
 * Copyright (c) 2008-2014, XebiaLabs B.V., All rights reserved.
 *
 *
 * Overthere is licensed under the terms of the GPLv2
 * <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most XebiaLabs Libraries.
 * There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
 * this software, see the FLOSS License Exception
 * <http://github.com/xebialabs/overthere/blob/master/LICENSE>.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms
 * of the GNU General Public License as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
 * Floor, Boston, MA 02110-1301  USA
 */
package com.xebialabs.overthere.ssh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xebialabs.overthere.ConnectionOptions;
import com.xebialabs.overthere.spi.AddressPortMapper;

import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SUDO_PASSWORD_PROMPT_REGEX;
import static com.xebialabs.overthere.ssh.SshConnectionBuilder.SUDO_PASSWORD_PROMPT_REGEX_DEFAULT;

/**
 * A connection to a Unix host using SSH w/ interactive SUDO.
 */
class SshInteractiveSudoConnection extends SshSudoConnection {

    public SshInteractiveSudoConnection(String type, ConnectionOptions options, AddressPortMapper mapper) {
        super(type, options, mapper);

        elevatedPassword = password;
        elevatedPasswordPromptRegex = options.get(SUDO_PASSWORD_PROMPT_REGEX, SUDO_PASSWORD_PROMPT_REGEX_DEFAULT);

        checkElevatedPasswordPromptRegex(this, SUDO_PASSWORD_PROMPT_REGEX, logger);
    }

    private Logger logger = LoggerFactory.getLogger(SshInteractiveSudoConnection.class);

}
