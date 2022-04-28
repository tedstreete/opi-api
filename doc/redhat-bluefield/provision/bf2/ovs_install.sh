#!/bin/bash

# Usage:
# To execute on remote host:
# 	ssh root@hostname 'bash -s' < ovs_install.sh
# Local host:
# 	./ovs_install.sh
#

# Ignore SSL certificate errors
grep -q "sslverify=false" /etc/yum.conf || echo "sslverify=false" >> /etc/yum.conf

BREW_ROOT="http://download.eng.bos.redhat.com/brewroot/vol/rhel-8/packages/"
OVS_RPMS=("openvswitch2.15/2.15.0/28.el8fdp/$(uname -m)/network-scripts-openvswitch2.15-2.15.0-28.el8fdp.$(uname -m).rpm"
          "openvswitch2.15/2.15.0/28.el8fdp/$(uname -m)/openvswitch2.15-2.15.0-28.el8fdp.$(uname -m).rpm"
          "openvswitch2.15/2.15.0/28.el8fdp/$(uname -m)/openvswitch2.15-devel-2.15.0-28.el8fdp.$(uname -m).rpm"
          "openvswitch2.15/2.15.0/28.el8fdp/$(uname -m)/openvswitch2.15-ipsec-2.15.0-28.el8fdp.$(uname -m).rpm"
          "openvswitch2.15/2.15.0/28.el8fdp/$(uname -m)/python3-openvswitch2.15-2.15.0-28.el8fdp.$(uname -m).rpm"
          "openvswitch-selinux-extra-policy/1.0/28.el8fdp/noarch/openvswitch-selinux-extra-policy-1.0-28.el8fdp.noarch.rpm")

dnf install -y kernel-modules-extra $(for I in ${OVS_RPMS}; do echo ${BREW_ROOT}${I}; done)

systemctl enable openvswitch
systemctl start openvswitch
systemctl status openvswitch --no-pager -l
